/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IPZappWindow;

/**
 *
 * @author lenovo
 */
public class Configuration {
    private int issuingVelocity;
    private int ejectionDistance;
    private int startRamp;
    private int stopRamp;
    private int startDelay;
    private int stopDelay;
    private double velocityDifference;
    private String name;
    private String format;

    public Configuration(int issuingVelocity, int ejectionDistance, int startRamp, int stopRamp, int startDelay, int stopDelay, double velocityDifference, String name, String format) {
        this.issuingVelocity = issuingVelocity;
        this.ejectionDistance = ejectionDistance;
        this.startRamp = startRamp;
        this.stopRamp = stopRamp;
        this.startDelay = startDelay;
        this.stopDelay = stopDelay;
        this.velocityDifference = velocityDifference;
        this.name = name;
        this.format = format;
    }
    
    public String toString()
    {
        return name;
    }

    public int getIssuingVelocity() {
        return issuingVelocity;
    }

    public void setIssuingVelocity(int issuingVelocity) {
        this.issuingVelocity = issuingVelocity;
    }

    public int getEjectionDistance() {
        return ejectionDistance;
    }

    public void setEjectionDistance(int ejectionDistance) {
        this.ejectionDistance = ejectionDistance;
    }

    public int getStartRamp() {
        return startRamp;
    }

    public void setStartRamp(int startRamp) {
        this.startRamp = startRamp;
    }

    public int getStopRamp() {
        return stopRamp;
    }

    public void setStopRamp(int stopRamp) {
        this.stopRamp = stopRamp;
    }

    public int getStartDelay() {
        return startDelay;
    }

    public void setStartDelay(int startDelay) {
        this.startDelay = startDelay;
    }

    public int getStopDelay() {
        return stopDelay;
    }

    public void setStopDelay(int stopDelay) {
        this.stopDelay = stopDelay;
    }

    public double getVelocityDifference() {
        return velocityDifference;
    }

    public void setVelocityDifference(double velocityDifference) {
        this.velocityDifference = velocityDifference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
    
}
