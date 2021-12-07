package com.atos.campus.pixies.trainingmanagementsystem.controller;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingRequirementMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.VerticalMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.LDMemberDataDAO;

import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;
import com.atos.campus.pixies.trainingmanagementsystem.model.VerticalMaster;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDMemberData;

import java.util.ArrayList;
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
	
	@GetMapping("/InProcessTraining")
	public String InProcessTraining(@RequestParam(name = "requirementID", required = true) String requirementID, Model model) {
		
		TrainingRequirementMaster requirement;
		VerticalMaster vertical;
		List<TrainingProposals> proposals;
		List<LDMemberData> ldMembers;
		
<<<<<<< HEAD
=======
		Test test = new Test();
		
>>>>>>> EduardoChapa
		requirement = trmDAO.get(requirementID);
		vertical = vmDAO.get(requirement.getRequirementUserVertical());
		proposals = tpDAO.getByRequirementID(requirementID);
		ldMembers = new ArrayList<LDMemberData>();
		
		for (TrainingProposals proposal : proposals)
			ldMembers.add(ldMemberDAO.get(proposal.getMemberID()));
		
		model.addAttribute("requirement", requirement);
		model.addAttribute("vertical", vertical);
		model.addAttribute("proposals", proposals);
		model.addAttribute("ldMembers", ldMembers);
<<<<<<< HEAD

	    return "View/InProcessTraining";
	}
}
=======
		model.addAttribute("test", test);

	    return "View/InProcessTraining";
	}
}

class Test {
	public void sayHi() {
		System.out.println("Hi");
	}
}
>>>>>>> EduardoChapa
