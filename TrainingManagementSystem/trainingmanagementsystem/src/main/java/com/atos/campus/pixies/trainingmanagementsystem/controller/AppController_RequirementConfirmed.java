package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDMemberData;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingExecutionMaster;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingRequirementMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.LDMemberDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingExecutionMasterDAO;

@Controller
public class AppController_RequirementConfirmed {

	@Autowired
	private TrainingRequirementMasterDAO trainingMaster;
	@Autowired
	private TrainingProposalsDAO trainingProposal;
	@Autowired
	private LDMemberDataDAO LDMember;
	@Autowired
	private TrainingExecutionMasterDAO trainingExecution;

	@GetMapping("/RequirementConfirmed")
	public String getOne(@RequestParam(name="requirementID") String requirementID, Model model){

		TrainingExecutionMaster main;
		LDMemberData trainner;
		TrainingProposals proposalsdata;
		TrainingRequirementMaster requirement;

		main = trainingExecution.get(requirementID);
		trainner = LDMember.get(main.getTrainer());
		proposalsdata = trainingProposal.get(main.getProposalID());
		requirement = trainingMaster.get(proposalsdata.getRequirementID());

		model.addAttribute("main", main);
		model.addAttribute("trainner", trainner);
		model.addAttribute("proposalsdata", proposalsdata);
		model.addAttribute("requirement", requirement);

		return "View/RequirementConfirmed";
	}

	@RequestMapping("/RequirementConfirmed")
	public String redirectView() {
		return "View/TrainingExecutionMaster";
	}
}

