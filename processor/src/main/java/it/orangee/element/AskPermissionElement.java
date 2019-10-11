/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Rurio Luca
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package it.orangee.element;




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

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import it.orangee.annotation.AskPermission;


public abstract class AskPermissionElement<T extends Element> {

    T element;

    AskPermission askPermission;

    AskPermissionElement(final T element) {
        this.element = element;
        this.askPermission = element.getAnnotation(AskPermission.class);
    }

    public AskPermission getAskPermission() {
        return askPermission;
    }

    public abstract String getClassName();

    abstract TypeElement getActivity();

    public T getElement() {
        return element;
    }

}
