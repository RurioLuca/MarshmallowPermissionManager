package it.orangee.element;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

/*

   ____                _         _           
  / ___|_ __ ___  __ _| |_ ___  | |__  _   _ 
 | |   | '__/ _ \/ _` | __/ _ \ | '_ \| | | |
 | |___| | |  __/ (_| | |_  __/ | |_) | |_| |
  \____|_|  \___|\__,_|\__\___| |_.__/ \__, |
                                       |___/                                                                      

  ____             _         _                    
 |  _ \ _   _ _ __(_) ___   | |   _   _  ___ __ _ 
 | |_) | | | | '__| |/ _ \  | |  | | | |/ __/ _` |
 |  _ <| |_| | |  | | (_) | | |___ |_| | (__ (_| |
 |_| \_\\__,_|_|  |_|\___/  |_____\__,_|\___\__,_|
  
  
  07/02/2019                 
                                                   
*/

public class AnnotateMethod extends AskPermissionElement<ExecutableElement> {

    public AnnotateMethod(final ExecutableElement element) {
        super(element);
    }

    @Override
    public String getClassName() {
        return ((TypeElement) element.getEnclosingElement()).getQualifiedName().toString();
    }

    @Override
    TypeElement getActivity() {
        return (TypeElement) element.getEnclosingElement();
    }

    String getMethodName() {
        return element.getSimpleName().toString();
    }
}

