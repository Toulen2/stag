package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;
import com.sun.jdi.Value;

import java.util.Date;

public class Specialization {
    @SerializedName("programNazev")
    public String programName;

    @SerializedName("oborNazev")
    public String oborNazev;

    @SerializedName("eprDeadlinePrihlaska")
    public Deadline eprDeadlinePrihlaska;
}
