/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IPZappWindow;
import java.sql.Timestamp;
/**
 *
 * @author lenovo
 */
public class ConfigurationStats {
    Timestamp startDate;
    Timestamp stopDate;
    int information1;
    int information2;
    int information3;
    String name;

    public ConfigurationStats(Timestamp startDate, Timestamp stopDate, int information1, int information2, int information3, String name) {
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.information1 = information1;
        this.information2 = information2;
        this.information3 = information3;
        this.name = name;
    }
    
    public String toString()
    {
        return name;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getStopDate() {
        return stopDate;
    }

    public void setStopDate(Timestamp stopDate) {
        this.stopDate = stopDate;
    }

    public int getInformation1() {
        return information1;
    }

    public void setInformation1(int information1) {
        this.information1 = information1;
    }

    public int getInformation2() {
        return information2;
    }

    public void setInformation2(int information2) {
        this.information2 = information2;
    }

    public int getInformation3() {
        return information3;
    }

    public void setInformation3(int information3) {
        this.information3 = information3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
