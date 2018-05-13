/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemcore;

import AiCSPhwCore.CSP;
import AiCSPhwCore.CSP;
import AiCSPhwCore.Domain;
import AiCSPhwCore.Domain;
import AiCSPhwCore.NotEqualConstraint;
import AiCSPhwCore.NotEqualConstraint;
import AiCSPhwCore.Variable;
import AiCSPhwCore.Variable;

/**
 *
 * @author Melih
 */
public class ScheduleCSP extends CSP {
    public static final Variable C1 = new Variable("CLASS 1  Intro to Programming");
    public static final Variable C2 = new Variable("CLASS 2 Intro to Artificial Intelligence");
    public static final Variable C3 = new Variable("CLASS 3 Natural Language Processing");
    public static final Variable C4 = new Variable("CLASS 4 Computer Vision");
    public static final Variable C5 = new Variable("CLASS 5  Machine Learning");

   //Changed Classroom names with Instructor names it changes nothing in result
   //But makes it look lot cooler
    public static final String A01 = "PROFFESOR GUNAY";
    public static final String B01 = "PROFESSOR DANISMAN";
    public static final String C01 = "PROFESSOR AK";

    /**
     * Constructs a map CSP for the principal states and territories of
     * Australia, with the colors Red, Green, and Blue.
     */
    public ScheduleCSP() {
        collectVariables();

        Domain a01 = new Domain(new Object[]{A01});
        Domain b01 =new Domain (new Object[]{B01});
        Domain c01 =new Domain (new Object[]{C01});
        Domain ab01 = new Domain(new Object[]{A01,B01});
        Domain ac01 =new Domain (new Object[]{A01,C01});
        Domain bc01 = new Domain(new Object[]{B01,C01});
        Domain abc01 =new Domain (new Object[]{A01,B01,C01});
        

        
            setDomain(C1,c01 );
            setDomain(C2,bc01);
            setDomain(C3,abc01);
            setDomain(C4,abc01);
            setDomain(C5,bc01);
            

        addConstraint(new NotEqualConstraint(C1, C2));
        addConstraint(new NotEqualConstraint(C2, C3));
        addConstraint(new NotEqualConstraint(C2, C4));
        addConstraint(new NotEqualConstraint(C3, C4));
        addConstraint(new NotEqualConstraint(C3, C5));
        addConstraint(new NotEqualConstraint(C4, C5));
   
    }

    /**
     * Returns the principle states and territories of Australia as a list of
     * variables.
     *
     * @return the principle states and territories of Australia as a list of
     * variables.
     */
    private void collectVariables() {
        addVariable(C1);
        addVariable(C2);
        addVariable(C3);
        addVariable(C4);
        addVariable(C5);
       
    }
}
