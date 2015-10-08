package org.gniza.biking.equipment.graphmodel;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NodeEntity
public class Athlete {
    @GraphId
    private Long id;

    private String externalId;
    private SourceSystemEnum sourceSystem;

    private String firstname;
    private String lastname;
    private String profileMedium;
    private String profile;
    private String city;
    private String state;
    private String country;
    private SexEnum sex;
    private Boolean premium;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private String datePreference;
    private MeasurementPreferenceEnum measurementPreference;
    private String email;
    private List<EquipmentItem> bikes = new ArrayList<EquipmentItem>();
    @Relationship(type = "ACTIVITY", direction = Relationship.OUTGOING)
    private Set<Activity> activities = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public SourceSystemEnum getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(SourceSystemEnum sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfileMedium() {
        return profileMedium;
    }

    public void setProfileMedium(String profileMedium) {
        this.profileMedium = profileMedium;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDatePreference() {
        return datePreference;
    }

    public void setDatePreference(String datePreference) {
        this.datePreference = datePreference;
    }

    public MeasurementPreferenceEnum getMeasurementPreference() {
        return measurementPreference;
    }

    public void setMeasurementPreference(MeasurementPreferenceEnum measurementPreference) {
        this.measurementPreference = measurementPreference;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EquipmentItem> getBikes() {
        return bikes;
    }

    public void setBikes(List<EquipmentItem> bikes) {
        this.bikes = bikes;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }
}