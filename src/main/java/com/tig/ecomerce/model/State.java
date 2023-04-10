package com.tig.ecomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "states")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "state_type_id")
	private StateType stateType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StateType getStateType() {
		return stateType;
	}
	public void setStateType(StateType stateType) {
		this.stateType = stateType;
	}
	public State(int id, String name, StateType stateType) {
		super();
		this.id = id;
		this.name = name;
		this.stateType = stateType;
	}
	public State() {
		super();
	}
	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", stateType=" + stateType + "]";
	}
	
}
