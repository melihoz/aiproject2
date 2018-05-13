/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AiCSPhwCore;

import problemcore.ScheduleCSP;

/**
 *
 * @author Melih Öz
 */
public class Main {
    public static void main(String args[]){
   // MapCSP map = new MapCSP();
    ScheduleCSP map = new ScheduleCSP();
   
    //pick any method combination from cases thats all you need to do
    //for the sake of simplicity just change the strategy choice value
    int strategychoice = 5;
    SolutionStrategy strategy = null;
    ImprovedBacktrackingStrategy iStrategy = null;

                               switch (strategychoice) {
				case 0:
                                        System.out.println("Backtracking Chosen");
					strategy = new BacktrackingStrategy();
					break;
				case 1: // MRV + DEG
                                        System.out.println("Backtracking with MRW + DEG Chosen");
					strategy = new ImprovedBacktrackingStrategy
					(true, true, false, false);
					break;
				case 2: // FC
                                    System.out.println("Backtracking with FC Chosen");
					iStrategy = new ImprovedBacktrackingStrategy();
					iStrategy.setInference(ImprovedBacktrackingStrategy
									.Inference.FORWARD_CHECKING);
					break;
				case 3: // MRV + FC 
                                    System.out.println("Backtracking with MRW + FC Chosen");
					iStrategy = new ImprovedBacktrackingStrategy
					(true, false, false, false);
					iStrategy.setInference(ImprovedBacktrackingStrategy
									.Inference.FORWARD_CHECKING);
					break;
				case 4: // FC + LCV
                                        System.out.println("Backtracking with FC + LCV Chosen");
					iStrategy = new ImprovedBacktrackingStrategy
					(false, false, false, true);
					iStrategy.setInference(ImprovedBacktrackingStrategy
									.Inference.FORWARD_CHECKING);
					break;
				case 5: // AC3
                                        System.out.println("Backtracking with AC3 Chosen");
					strategy = new ImprovedBacktrackingStrategy
					(false, false, true, false);
					break;
				case 6: // MRV + DEG + AC3 + LCV
                                        System.out.println("Backtracking with AC3 Chosen");
					strategy = new ImprovedBacktrackingStrategy
					(true, true, true, true);
					break;
				case 7:
                                        System.out.println("MinConflictsStrategy Chosen");
					strategy = new MinConflictsStrategy(50);
					break;
				}
				if (iStrategy != null)
					strategy = iStrategy;
				
				
					strategy.addCSPStateListener(new CSPStateListener() {
						@Override
						public void stateChanged(Assignment assignment, CSP csp) {
						 System.out.println("Assignment evolved : " + assignment);	
						}
					    @Override
						public void stateChanged( CSP csp) {
                                                System.out.println("CSP evolved domains: "); csp.getDomain();
						}
					});
					   System.out.println("Result: "+strategy.solve(map.copyDomains()));
                     
				}
			
                  
                    
    
}
  
				
		
