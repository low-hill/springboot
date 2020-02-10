package com.example.demo;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TicketDao{
	@Autowired
	private EntityManager em;
	
	public List<Ticket> getTicketInfo(){
		StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery("ZYKIM.GET_TICKETS", Ticket.class);
		
		procedureQuery.registerStoredProcedureParameter("PCUR", void.class, ParameterMode.REF_CURSOR);
		
		procedureQuery.execute();
		
		List<Ticket> resultList = (List<Ticket>)procedureQuery.getResultList();
		
		return resultList;
	}

}
