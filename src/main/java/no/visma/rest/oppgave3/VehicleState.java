package no.visma.rest.oppgave3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleState {

    private String sun_roof_state;
    private String roof_color;
    private int sun_roof_percent_open;
    private boolean pf;
    private String wheel_type;
    private boolean df;
    private String car_version;
    private boolean has_spoiler;
    private boolean rt;
    private boolean ft;
    private boolean locked;
    private boolean sun_roof_installed;
    private boolean dark_rims;
    private String perf_config;
    private boolean pr;
    private boolean dr;

    public String getSun_roof_state() {
        return sun_roof_state;
    }

    public void setSun_roof_state(String sun_roof_state) {
        this.sun_roof_state = sun_roof_state;
    }

    public String getRoof_color() {
        return roof_color;
    }

    public void setRoof_color(String roof_color) {
        this.roof_color = roof_color;
    }

    public int getSun_roof_percent_open() {
        return sun_roof_percent_open;
    }

    public void setSun_roof_percent_open(int sun_roof_percent_open) {
        this.sun_roof_percent_open = sun_roof_percent_open;
    }

    public boolean getPf() {
        return pf;
    }

    public void setPf(boolean pf) {
        this.pf = pf;
    }

    public String getWheel_type() {
        return wheel_type;
    }

    public void setWheel_type(String wheel_type) {
        this.wheel_type = wheel_type;
    }

    public boolean getDf() {
        return df;
    }

    public void setDf(boolean df) {
        this.df = df;
    }

    public String getCar_version() {
        return car_version;
    }

    public void setCar_version(String car_version) {
        this.car_version = car_version;
    }

    public boolean getHas_spoiler() {
        return has_spoiler;
    }

    public void setHas_spoiler(boolean has_spoiler) {
        this.has_spoiler = has_spoiler;
    }

    public boolean getRt() {
        return rt;
    }

    public void setRt(boolean rt) {
        this.rt = rt;
    }

    public boolean getFt() {
        return ft;
    }

    public void setFt(boolean ft) {
        this.ft = ft;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean getSun_roof_installed() {
        return sun_roof_installed;
    }

    public void setSun_roof_installed(boolean sun_roof_installed) {
        this.sun_roof_installed = sun_roof_installed;
    }

    public boolean getDark_rims() {
        return dark_rims;
    }

    public void setDark_rims(boolean dark_rims) {
        this.dark_rims = dark_rims;
    }

    public String getPerf_config() {
        return perf_config;
    }

    public void setPerf_config(String perf_config) {
        this.perf_config = perf_config;
    }

    public boolean getPr() {
        return pr;
    }

    public void setPr(boolean pr) {
        this.pr = pr;
    }

    public boolean getDr() {
        return dr;
    }

    public void setDr(boolean dr) {
        this.dr = dr;
    }
}
