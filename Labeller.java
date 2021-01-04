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
class Labeller {
    private String name;
    private String IPAddress;
    public Labeller(String name, String IPAddress)
    {
        this.name = name;
        this.IPAddress = IPAddress;
    }
    public String toString()
    {
        return new String(name + " (" + IPAddress + ")");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }
    
}
