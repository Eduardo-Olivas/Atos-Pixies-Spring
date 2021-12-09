package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingRequirementMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.VerticalMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;
import com.atos.campus.pixies.trainingmanagementsystem.model.VerticalMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerIndex {

	@Autowired
	private TrainingRequirementMasterDAO trainingMaster;
	@Autowired
	private TrainingProposalsDAO trainingProposal;
    @Autowired
    private VerticalMasterDAO verticalMaster;
	
    @GetMapping(value = "/")
	public String mainPage(Model model, @RequestParam(required=false) String id) {
		if (id == null || id.equals(""))
			return "index";
        
        List<HashMap<String,String>> listReq = new ArrayList<>();
        for (TrainingRequirementMaster i : trainingMaster.list()) {
            HashMap<String,String> requirementMap = new HashMap<>();
            requirementMap.put("RequirementID", i.getRequirementID());            
            requirementMap.put("Area", i.getTrainingArea());
            requirementMap.put("ReceivedDate", i.getRequirementReceivedDate().toString());
            requirementMap.put("StartDate", i.getRequestedTrainingStartDate().toString());            
            requirementMap.put("Duration", i.getTotalDurationDays() + " days");
            requirementMap.put("Status", "New");
            VerticalMaster v = verticalMaster.get(i.getRequirementUserVertical());
            requirementMap.put("Vertical", v.getVerticalName());
            TrainingProposals p = trainingProposal.get(
                "SELECT * FROM TrainingProposals WHERE RequirementID = ?",
                i.getRequirementID());
                if (p!=null) {
                if (p.getProposedDuration() != 0) {
                    requirementMap.put("Duration", p.getProposedDuration() + " days");
                }
                requirementMap.put("Status", p.getProposalStatus());
            }
            String linkTo;
            switch (requirementMap.get("Status")) {
                case "New":
                    linkTo = "/View/NewRequirement/"  + i.getRequirementID();
                    break;
                case "Confirmed":
                    linkTo = "/View/RequirementConfirmed/" + i.getRequirementID();
                    break;
                case "Pending":
                    linkTo = "/View/"  + i.getRequirementID();
                    break;
                case "Process":
                    linkTo = "/View/InProcessTraining/"  + i.getRequirementID();
                    break;
                case "Rejected":
                    linkTo = "/View/LBPRejected/"  + i.getRequirementID();
                    break;
                default:
                    linkTo = "#";
                    break;
            }
            requirementMap.put("Link", linkTo);
            listReq.add(requirementMap);
        }
        model.addAttribute("listRequirement", listReq);
		return "View/indexLBP";
	}
}
    