package com.atos.campus.pixies.trainingmanagementsystem.controller;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingRequirementMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.VerticalMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.LDMemberDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingExecutionMasterDAO;

import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;
import com.atos.campus.pixies.trainingmanagementsystem.model.VerticalMaster;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDMemberData;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingExecutionMaster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController_InProcessTraining {
	
	@Autowired
	private TrainingProposalsDAO tpDAO;
	@Autowired
	private TrainingRequirementMasterDAO trmDAO;
	@Autowired
	private VerticalMasterDAO vmDAO;
	@Autowired
	private LDMemberDataDAO ldMemberDAO;
	@Autowired
	private TrainingExecutionMasterDAO temDAO;
	
	List<TrainingExecutionMaster> executions;
	TrainingRequirementMaster requirement;
	VerticalMaster vertical;
	List<TrainingProposals> proposals;
	List<LDMemberData> ldMembers;
	
	@GetMapping("/InProcessTraining")
	public String InProcessTraining(@RequestParam(name = "requirementID", required = true) String requirementID, Model model) {
		
		//Get the requirement data
		requirement = trmDAO.get(requirementID);
		//Get the vertical data
		vertical = vmDAO.get(requirement.getRequirementUserVertical());
		//Get the proposals list
		proposals = tpDAO.getByRequirementID(requirementID);
		//Initialize trainers data
		ldMembers = new ArrayList<LDMemberData>();
		//Initialize the executions list
		executions = new ArrayList<TrainingExecutionMaster>();
		
		//Get the executions from the proposals
		for (TrainingProposals proposal : proposals) {
			System.out.println(proposal);
			executions.addAll(temDAO.getByProposalID(proposal.getProposalID()));				
		}
		
		for (TrainingExecutionMaster e : executions)
			System.out.println(e);
		
		//Get trainers data from the proposals
		for (TrainingProposals proposal : proposals)
			ldMembers.add(ldMemberDAO.get(proposal.getMemberID()));
		
		//Add all the data to the model
		model.addAttribute("requirement", requirement);
		model.addAttribute("vertical", vertical);
		model.addAttribute("proposals", proposals);
		model.addAttribute("ldMembers", ldMembers);
		model.addAttribute("executions", executions);
		
		System.out.println(requirement);

	    return "View/InProcessTraining";
	}
	
	@GetMapping("/send")
	public String sendResponse(@RequestParam(value = "proposalID") String proposalID, Model model) {
		
		Date confirmedDate = new Date();
		String confirmedTime = "";
		
		for (TrainingExecutionMaster e : executions) {
			if (e.getProposalID() == proposalID) {
				confirmedDate = e.getConfirmedDate();
				confirmedTime = e.getConfirmedTime();
				break;
			}
		}
		
		for (TrainingProposals proposal : proposals) {
			if (proposal.getProposalID() == proposalID) {
				proposal.setProposalStatus("Confirmed");
				proposal.setProposedDate(confirmedDate);
				proposal.setProposedTime(confirmedTime);
				tpDAO.update(proposal);
			}
			else {
				proposal.setProposalStatus("Rejected");
//				tpDAO.update(proposal);
			}
		}
		
		return "View/IndexLBP";
	}
}