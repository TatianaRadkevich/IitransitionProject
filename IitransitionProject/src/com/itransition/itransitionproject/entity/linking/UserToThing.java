package com.itransition.itransitionproject.entity.linking;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.User;

@Entity
@Table(name = "user_to_thing", catalog = "database")
@AssociationOverrides({
		@AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "ID_USER")),
		@AssociationOverride(name = "pk.thing", joinColumns = @JoinColumn(name = "ID_THING")) })
public class UserToThing implements java.io.Serializable {

	private UserToThingId pk = new UserToThingId();
	
	public UserToThing() {
	}

	
	/**
	 * @return the pk
	 */
	@EmbeddedId
	public UserToThingId getPk() {
		return pk;
	}


	/**
	 * @param pk the pk to set
	 */
	public void setPk(UserToThingId pk) {
		this.pk = pk;
	}


	@Transient
	public User getUser() {
		return getPk().getUser();
	}

	public void setUser(User user) {
		getPk().setUser(user);
	}

	@Transient
	public Thing getThing() {
		return getPk().getThing();
	}

	public void setThing(Thing thing) {
		getPk().setThing(thing);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserToThing that = (UserToThing) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}