package no.visma.rest.oppgave3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {

    private String remote_start_enabled;
    private String backseat_token_updated_at;
    private String state;
    private String vehicle_id;
    private String calendar_enabled;
    private String id;
    private String id_s;
    private String display_name;
    private String notifications_enabled;
    private String color;
    private String vin;
    private String backseat_token;
    private String[] tokens;
    private String option_codes;

    public String getRemote_start_enabled() {
        return remote_start_enabled;
    }

    public void setRemote_start_enabled(String remote_start_enabled) {
        this.remote_start_enabled = remote_start_enabled;
    }

    public String getBackseat_token_updated_at() {
        return backseat_token_updated_at;
    }

    public void setBackseat_token_updated_at(String backseat_token_updated_at) {
        this.backseat_token_updated_at = backseat_token_updated_at;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getCalendar_enabled() {
        return calendar_enabled;
    }

    public void setCalendar_enabled(String calendar_enabled) {
        this.calendar_enabled = calendar_enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_s() {
        return id_s;
    }

    public void setId_s(String id_s) {
        this.id_s = id_s;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getNotifications_enabled() {
        return notifications_enabled;
    }

    public void setNotifications_enabled(String notifications_enabled) {
        this.notifications_enabled = notifications_enabled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getBackseat_token() {
        return backseat_token;
    }

    public void setBackseat_token(String backseat_token) {
        this.backseat_token = backseat_token;
    }

    public String[] getTokens() {
        return tokens;
    }

    public void setTokens(String[] tokens) {
        this.tokens = tokens;
    }

    public String getOption_codes() {
        return option_codes;
    }

    public void setOption_codes(String option_codes) {
        this.option_codes = option_codes;
    }
}
