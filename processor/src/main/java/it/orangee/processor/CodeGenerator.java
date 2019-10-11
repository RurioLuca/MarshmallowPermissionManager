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
package it.orangee.processor;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.processing.Filer;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

import it.orangee.annotation.AskPermission;
import it.orangee.element.AskPermissionElement;

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

public class CodeGenerator {

    private static final String EXTRA_METHOD = "shortbread_method";
    private final ClassName suppressLint = ClassName.get("android.annotation", "SuppressLint");
    private final ClassName context = ClassName.get("android.content", "Context");
    private final ClassName permissionInfo = ClassName.get("android.content.pm", "PermissionInfo");
    private final ClassName intent = ClassName.get("android.content", "Intent");
    private final ClassName icon = ClassName.get("android.graphics.drawable", "Icon");
    private final ClassName activity = ClassName.get("android.app", "Activity");
    private final ClassName componentName = ClassName.get("android.content", "ComponentName");
    private final ClassName list = ClassName.get("java.util", "List");
    private final TypeName listOfPermissionInfo = ParameterizedTypeName.get(list, permissionInfo);
    private final TypeName listOfListOfPermissionInfo = ParameterizedTypeName.get(list, listOfPermissionInfo);
    private final ClassName taskStackBuilder = ClassName.get("android.app", "TaskStackBuilder");
    private final ClassName permissionUtils = ClassName.get("permissionhelper", "PermissionUtils");

    private Filer filer;
    private List<AskPermissionElement> annotatedElements;

    CodeGenerator(final Filer filer, final List<AskPermissionElement> annotatedElements) {
        this.filer = filer;
        this.annotatedElements = annotatedElements;
    }

    void generate() {
        TypeSpec permissionHelper = TypeSpec.classBuilder("AskPermissionGenerated")
                .addAnnotation(AnnotationSpec.builder(suppressLint)
                        .addMember("value", "$S", "NewApi")
                        .addMember("value", "$S", "ResourceType")
                        .build())
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
        //        .addMethod(createShortcuts())
                .addMethod(callMethodPermission())
                .build();

        JavaFile javaFile = JavaFile.builder("permissionhelper", permissionHelper)
                .indent("    ")
                .build();

        try {
            javaFile.writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public MethodSpec callMethodPermission(){


    final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("createShortcuts")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .returns(listOfListOfPermissionInfo)
            .addParameter(context, "context")
            .addStatement("$T<$T> enabledShortcuts = new $T<>()", List.class, permissionInfo, ArrayList.class)
            .addStatement("$T<$T> disabledShortcuts = new $T<>()", List.class, permissionInfo, ArrayList.class);

    for (final AskPermissionElement annotatedElement : annotatedElements) {
        AskPermission askPermission = annotatedElement.getAskPermission();
        String permission = askPermission.permission();
        boolean callback = askPermission.callback();

      //  methodBuilder.addCode("$L.add(", askPermission.enabled() ? "enabledShortcuts" : "disabledShortcuts");
        methodBuilder.addCode(Objects.requireNonNull(askingPermission(annotatedElement)));
        methodBuilder.addStatement(")");
    }

    return methodBuilder
            .addStatement("return $T.asList(enabledShortcuts, disabledShortcuts)", Arrays.class)
            .build();

}
private CodeBlock askingPermission(AskPermissionElement annotatedElement){

return null;

        AskPermission askPermission = annotatedElement.getAskPermission();

        final CodeBlock.Builder blockBuilder = CodeBlock.builder();

        blockBuilder.add("new $T.Builder(context, $S)\n", permissionInfo, askPermission.permission())
                .indent()
                .indent();

        if (!"".equals(askPermission.permission())) {
         //   blockBuilder.add(".setShortLabel($S)\n", askPermission.permission());

        } else {
          //  blockBuilder.add(".setShortLabel($T.getActivityLabel(context, $T.class))\n", permissionUtils,
            //        ClassName.bestGuess(annotatedElement.getClassName()));
        }






      /*  blockBuilder.add(".setIntents(")
                .indent().indent()
                .add("$T.create(context)\n", taskStackBuilder);
*/


        // because we can't just get an array of classes, we have to use AnnotationMirrors
        final List<? extends AnnotationMirror> annotationMirrors = annotatedElement.getElement().getAnnotationMirrors();
        for (final AnnotationMirror annotationMirror : annotationMirrors) {
            if (annotationMirror.getAnnotationType().toString().equals(AskPermission.class.getName())) {
                for (Map.Entry<? extends Element, ? extends AnnotationValue> entry : annotationMirror.getElementValues().entrySet()) {
                    if ("backStack".equals(entry.getKey().getSimpleName().toString())) {
                        final String value = entry.getValue().getValue().toString();
                        if (!"".equals(value.trim())) {
                            for (final String backstackActivityClassName : value.split(",")) {
                                blockBuilder.add(".addNextIntent(new $T($T.ACTION_VIEW).setClass(context, $T.class))\n",
                                        intent, intent, ClassName.bestGuess(backstackActivityClassName.replace(".class", "")));
                            }
                        }
                    }
                }
            }
        }

        blockBuilder.add(".addNextIntent(new $T(context, $T.class)\n", intent, activityClassName);
        blockBuilder.indent().indent();
        if ("".equals(shortcut.action())) {
            blockBuilder.add(".setAction($T.ACTION_VIEW)", intent);
        } else {
            blockBuilder.add(".setAction($S)", shortcut.action());
        }
        if (annotatedElement instanceof ShortcutAnnotatedMethod) {
            blockBuilder.add("\n.putExtra($S, $S)", EXTRA_METHOD, ((ShortcutAnnotatedMethod) annotatedElement).getMethodName());
        }
        blockBuilder.unindent().unindent();

        return blockBuilder.add(")\n")
                .add(".getIntents())\n")
                .unindent().unindent()
                .add(".setRank($L)\n", shortcut.rank())
                .add(".build()")
                .unindent().unindent()
                .build();
    }

    private MethodSpec callMethodPermission() {
        HashMap<String, List<String>> classMethodsMap = new HashMap<>();

        for (final ShortcutAnnotatedElement annotatedElement : annotatedElements) {
            if (annotatedElement instanceof ShortcutAnnotatedMethod) {
                final ShortcutAnnotatedMethod annotatedMethod = (ShortcutAnnotatedMethod) annotatedElement;
                if (classMethodsMap.containsKey(annotatedMethod.getClassName())) {
                    classMethodsMap.get(annotatedElement.getClassName()).add(annotatedMethod.getMethodName());
                } else {
                    classMethodsMap.put(annotatedMethod.getClassName(), new ArrayList<String>() {{
                        add(annotatedMethod.getMethodName());
                    }});
                }
            }
        }

        final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("callMethodShortcut")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(activity, "activity");

        for (final Map.Entry<String, List<String>> annotatedMethodName : classMethodsMap.entrySet()) {
            ClassName activityClassName = ClassName.bestGuess(annotatedMethodName.getKey());
            List<String> methodNames = annotatedMethodName.getValue();
            methodBuilder.beginControlFlow("if (activity instanceof $T)", activityClassName);
            for (final String methodName : methodNames) {
                methodBuilder.beginControlFlow("if ($S.equals(activity.getIntent().getStringExtra($S)))", methodName, EXTRA_METHOD);
                methodBuilder.addStatement("(($T) activity).$L()", activityClassName, methodName);
                methodBuilder.endControlFlow();
            }
            methodBuilder.endControlFlow();
        }

        return methodBuilder
                .build();
    }

}
