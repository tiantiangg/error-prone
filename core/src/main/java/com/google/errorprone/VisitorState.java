/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone;

import com.sun.source.util.TreePath;
import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.code.Types;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;

/**
 * Carries the current state of the visitor as it visits tree nodes.
 * @author alexeagle@google.com (Alex Eagle)
 */
public class VisitorState {
  private final Context context;
  private final Reporter reporter;
  private final TreePath path;

  public VisitorState(Context context, Reporter reporter, TreePath path) {
    this.context = context;
    this.reporter = reporter;
    this.path = path;
  }

  public VisitorState(Context context, Reporter reporter) {
    this(context, reporter, null);
  }

  public VisitorState withPath(TreePath path) {
    return new VisitorState(context, reporter, path);
  }

  public TreePath getPath() {
    return path;
  }

  public TreeMaker getTreeMaker() {
    return TreeMaker.instance(context);
  }

  public Types getTypes() {
    return Types.instance(context);
  }

  public Symtab getSymtab() {
    return Symtab.instance(context);
  }

  public Reporter getReporter() {
    return reporter;
  }
}
