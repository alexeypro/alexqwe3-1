package com.qwe3.sandbox.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.qwe3.sandbox.base.PMF;
import com.qwe3.sandbox.model.Profile;

import javax.jdo.PersistenceManager;

public class RecordAction extends ActionSupport implements Preparable {

	private Profile profile;
        private List profiles;

	public String doSave() {
		if (profile.getId() == null) {
			PMF.get().getPersistenceManager().makePersistent(profile);
		} else {
			PersistenceManager pm = PMF.get().getPersistenceManager();
                        Profile profileOld = pm.getObjectById(Profile.class, profile.getId());
                        profileOld.setEmail( profile.getEmail() );
                        profileOld.setName( profile.getName() );
                        pm.makePersistent(profileOld);
                        pm.close(); // important!!!
                }
		return SUCCESS;
	}

	public String doDelete() {
            PersistenceManager pm = PMF.get().getPersistenceManager();
            profile = pm.getObjectById(Profile.class, profile.getId());
            pm.deletePersistent(profile);
            return SUCCESS;
	}

	public String doList() {
                profiles = (List) PMF.get().getPersistenceManager().newQuery(Profile.class).execute();
		return SUCCESS;
	}

	public String doInput() {
		return INPUT;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List getProfiles() {
		return profiles;
	}

    public void prepare() throws Exception {
	if (profile != null && profile.getId() != null) {
            profile = PMF.get().getPersistenceManager().getObjectById(Profile.class, profile.getId());
        }
    }

}
