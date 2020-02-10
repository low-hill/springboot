package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ticket")
@Data
//@NamedStoredProcedureQueries({
//	@NamedStoredProcedureQuery(
//		name="getTicketPro",
//		procedureName="ZYKIM.GET_TICKETS",
//		resultClasses = Ticket.class,
//		parameters ={
//				@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, type=void.class)
//		}
//		)})
public class Ticket {
	@Id
	private int id;
	private int amount;
	private String category;
}