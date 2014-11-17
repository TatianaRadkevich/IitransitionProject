package com.itransition.itransitionproject.entity.linking;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.User;

@Embeddable
public class UserToThingId implements java.io.Serializable {

	private User user;
    private Thing thing;

	/**
	 * @return the user
	 */
    @ManyToOne
	public User getUser() {
		return user;
    }

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the thing
	 */
	@ManyToOne
	public Thing getThing() {
		return thing;
	}

	/**
	 * @param thing the thing to set
	 */
	public void setThing(Thing thing) {
		this.thing = thing;
	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserToThingId that = (UserToThingId) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (thing != null ? !thing.equals(that.thing) : that.thing != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (user != null ? user.hashCode() : 0);
        result = 31 * result + (thing != null ? thing.hashCode() : 0);
        return result;
    }
    
}