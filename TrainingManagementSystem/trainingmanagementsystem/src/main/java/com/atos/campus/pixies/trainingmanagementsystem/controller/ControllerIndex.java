package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.HashMap;
import java.util.Map;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingRequirementMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;

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

	@GetMapping(value = "/")
	public String mainPage(Model model, @RequestParam(required=false) String id) {
		if (id == null || id.equals(""))
			return "index";
        model.addAttribute("listTrainingMaster", trainingMaster.list());
        Map<String,TrainingProposals> temp = new HashMap<>();
        for (TrainingRequirementMaster i : trainingMaster.list()) {
            TrainingProposals p = trainingProposal.get(
                "SELECT * FROM TrainingProposals WHERE RequirementID = ?", i.getRequirementID());
                temp.put(i.getRequirementID(),p);
        }
        model.addAttribute("mapTrainingProposal", temp);
		return "View/indexLBP";
	}
}
