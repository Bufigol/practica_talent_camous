package com.accenture.fers.dao;

import java.util.Set;

import com.accenture.fers.entity.Event;

public interface IEventDAO {
	public Set<Event> findAll();

	public Event findOne(int eventId);

	public void save(Event myEvent);
}
