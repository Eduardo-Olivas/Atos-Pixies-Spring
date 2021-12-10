package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.atos.campus.pixies.trainingmanagementsystem.dao.LDMemberDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.LDRolesDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingExecutionMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingRequirementMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.VerticalMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDMemberData;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDRoles;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingExecutionMaster;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;
import com.atos.campus.pixies.trainingmanagementsystem.model.VerticalMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerIndex {

	@Autowired
    private TrainingExecutionMasterDAO trainingExecutions;
	@Autowired
	private TrainingRequirementMasterDAO trainingMaster;
	@Autowired
	private TrainingProposalsDAO trainingProposal;
    @Autowired
    private VerticalMasterDAO verticalMaster;
    @Autowired
    private LDMemberDataDAO memberData;
    @Autowired
    private LDRolesDAO rolesData;
	
    @GetMapping(value = "/index/{uid}")
	public String mainPageExplicit(Model model, @PathVariable(required=false) String uid, @RequestParam(required=false) String filter) {
        return mainPageImplicit(model, uid, filter);
    }

    @GetMapping(value = "/{uid}")
	public String mainPageImplicit(Model model, @PathVariable(required=false) String uid, @RequestParam(required=false) String filter) {
		System.out.println(uid);

        LDMemberData user = memberData.get(uid);
        if (user == null) {
		    return "index";
        }
        List<TrainingRequirementMaster> listTrainings;
        if (filter == null || filter.equals("")) {
            listTrainings = trainingMaster.list();
        } else {
            System.out.println(filter);
            listTrainings = trainingMaster.listTrainingStatus(filter);
        }
        
        LDRoles role = rolesData.get(user.getLDRoleID());
        model.addAttribute("userRol", role.getLDRoleName());
        switch (role.getLDRoleName()) {
            case "Trainer":
                return mainPageTrainer(model, uid);
            case "LBP":
                Set<String> verticalsLBP = verticalMaster.listByLPID(uid).stream()
                    .map(VerticalMaster::getVID)
                    .collect(Collectors.toSet());
                listTrainings.removeIf(e -> (!verticalsLBP.contains(e.getRequirementUserVertical())));
                break;
            case "Manager":
                listTrainings.removeIf(e -> (!e.getRequirementUser().equals(uid)));
                break;
            case "Admin":
                break;
            default:
                listTrainings.clear();
        }
        model.addAttribute("listRequirement", generateCardsMaps(listTrainings));
        return "View/IndexManagerLPB";
	}

    private String mainPageTrainer(Model model, String uid) {
        List<HashMap<String,String>> listCards = new ArrayList<>();
        for (TrainingExecutionMaster i : trainingExecutions.getByTrainer(uid)) {
            TrainingProposals p = trainingProposal.get(i.getProposalID());
            HashMap<String,String> cardMap = new HashMap<>();
            cardMap.put("RequirementID", p.getRequirementID());
            cardMap.put("MemberID", p.getMemberID());
            cardMap.put("ProposalID", p.getProposalID());
            cardMap.put("ProposedDate", p.getProposedDate().toString());
            cardMap.put("ProposedTime", p.getProposedTime());
            cardMap.put("ProposedDuration", String.format("%d", p.getProposedDuration()));
            cardMap.put("ProposalStatus", "New");
            listCards.add(cardMap);
        }
        model.addAttribute("listTrainingProposals", listCards);
        return "View/IndexTrainer";
    }

    private List<HashMap<String,String>> generateCardsMaps(List<TrainingRequirementMaster> list) {
        List<HashMap<String,String>> listCards = new ArrayList<>();
        for (TrainingRequirementMaster i : list) {
            HashMap<String,String> cardMap = new HashMap<>();
            cardMap.put("RequirementID", i.getRequirementID());            
            cardMap.put("Area", i.getTrainingArea());
            cardMap.put("ReceivedDate", i.getRequirementReceivedDate() + "");
            cardMap.put("StartDate", i.getRequestedTrainingStartDate() + "");            
            cardMap.put("Duration", i.getTotalDurationDays() + " days");
            cardMap.put("Status", "New");
            VerticalMaster v = verticalMaster.get(i.getRequirementUserVertical());
            cardMap.put("Vertical", v.getVerticalName());
            String linkTo;
            switch (cardMap.get("Status")) {
                case "New":
                    linkTo = "/NewRequirement"  + i.getRequirementID();
                    break;
                case "Confirmed":
                    linkTo = "/RequirementConfirmed?requirementID=" + i.getRequirementID();
                    break;
                case "Pending":
                    linkTo = "/"  + i.getRequirementID();
                    break;
                case "Process":
                    linkTo = "/InProcessTraining?requirementID="  + i.getRequirementID();
                    break;
                case "Rejected":
                    linkTo = "/LBPRejected/"  + i.getRequirementID();
                    break;
                default:
                    linkTo = "#";
            }
            cardMap.put("Link", linkTo);
            listCards.add(cardMap);
        }
        return listCards;
    }

}
    