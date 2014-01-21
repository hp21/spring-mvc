package com.springapp.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PrintComponentTree implements PhaseListener {
  public PrintComponentTree() {
  }

  public int indent = 0;
  public static final int INDENTSIZE = 2;

  public void beforePhase(PhaseEvent PhaseEvent) {
  }

  public void afterPhase(PhaseEvent PhaseEvent) {
    System.out.println("");
    System.out.println("(Rendering Component Tree)");
    printComponentTree(FacesContext.getCurrentInstance().getViewRoot());
  }

  public PhaseId getPhaseId() {
    return PhaseId.RENDER_RESPONSE;    
  }
  
  public void printComponentTree(UIComponent comp){
    printComponentInfo(comp);
    
    List complist = (List)comp.getChildren();
      if (complist.size() > 0) {
          indent++;
      }
    for   (int i = 0; i < complist.size(); i++) {
      UIComponent uicom = (UIComponent) complist.get(i);
      printComponentTree(uicom);
        if (i + 1 == complist.size()) {
            indent--;
        }
    }
    
  }

  public void printComponentInfo(UIComponent comp){
  
   if (comp.getId() == null){
     System.out.println("UIViewRoot" + " " + "(" + comp.getClass().getName() + ")");
   } else {
       printIndent();
       System.out.println("|");
       printIndent();
       System.out.println(comp.getId() + " " + "(" + comp.getClass().getName() + ")");
     }  
  }
 
  public void printIndent(){
    for (int i=0; i<indent; i++ )  
      for (int j=0;j<INDENTSIZE; j++)  
        System.out.print(" ");          
  }  
}