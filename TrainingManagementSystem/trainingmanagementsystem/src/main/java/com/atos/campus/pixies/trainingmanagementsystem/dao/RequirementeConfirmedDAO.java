package com.atos.campus.pixies.trainingmanagementsystem.dao;

import com.atos.campus.pixies.trainingmanagementsystem.model.RequirementConfirmed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RequirementeConfirmedDAO {
    @Autowired
	private JdbcTemplate jdbcTemplate;

    public RequirementConfirmed get(String requirementID) {
		String sql = "SELECT TEM.ExecutionID, TRM.RequirementReceivedDate, TP.ProposedDate,  (SELECT TRP.ProposedDate + 5 FROM TrainingProposals TRP INNER JOIN TrainingExecutionMaster TEM ON TRP.ProposalID = TEM.ProposalID WHERE TEM.ExecutionID = '1DFE') AS ProposedEndDate, M.MemberName, TEM.TotalParticipantsAllowed FROM TrainingExecutionMaster TEM INNER JOIN LDMemberData M ON M.MemberId = TEM.Trainer INNER JOIN TrainingProposals TP ON TP.ProposalID = TEM.ProposalID INNER JOIN TrainingRequirementMaster TRM ON TRM.RequirementID = TP.RequirementID WHERE TEM.ExecutionID = ?";
		Object[] args = {requirementID};
		RequirementConfirmed RequirementConfirmed = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(RequirementConfirmed.class));
		return RequirementConfirmed;
	}
}
