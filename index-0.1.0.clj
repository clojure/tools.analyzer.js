{:namespaces
 ({:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url "http://clojure.github.com/tools.analyzer.js/js-api.html",
   :name "clojure.tools.analyzer.js",
   :doc
   "Analyzer for clojurescript code, extends tools.analyzer with JS specific passes/forms"}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.analyze-host-expr-api.html",
   :name "clojure.tools.analyzer.passes.js.analyze-host-expr",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.annotate-tag-api.html",
   :name "clojure.tools.analyzer.passes.js.annotate-tag",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.collect-keywords-api.html",
   :name "clojure.tools.analyzer.passes.js.collect-keywords",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/54e429a472df4cc5cf512d4c7e1e06a343038d08/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.emit-form-api.html",
   :name "clojure.tools.analyzer.passes.js.emit-form",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/672f2964132b288d45861e42bfa0763ad17c2bf4/src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.infer-tag-api.html",
   :name "clojure.tools.analyzer.passes.js.infer-tag",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.validate-api.html",
   :name "clojure.tools.analyzer.passes.js.validate",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/js.cljs.core-api.html",
   :name "clojure.tools.analyzer.js.cljs.core",
   :doc nil}),
 :vars
 ({:arglists ([form] [form env] [form env opts]),
   :name "analyze",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L458",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/analyze",
   :doc
   "Returns an AST for the form.\n\nBinds tools.analyzer/{macroexpand-1,create-var,parse} to\ntools.analyzer.js/{macroexpand-1,create-var,parse} and analyzes the form.\n\nIf provided, opts should be a map of options to analyze, currently the only valid\noptions are :bindings and :passes-opts.\nIf provided, :bindings should be a map of Var->value pairs that will be merged into the\ndefault bindings for tools.analyzer, useful to provide custom extension points.\nIf provided, :passes-opts should be a map of pass-name-kw->pass-config-map pairs that\ncan be used to configure the behaviour of each pass.\n\nE.g.\n(analyze form env {:bindings  {#'ana/macroexpand-1 my-mexpand-1}})\n\nCalls `run-passes` on the AST.",
   :var-type "function",
   :line 458,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:arglists ([form] [form env] [form env opts]),
   :name "analyze'",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L492",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/analyze'",
   :doc "Like `analyze` but runs cleanup on the AST",
   :var-type "function",
   :line 492,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:arglists ([ns]),
   :name "analyze-ns",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L499",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/analyze-ns",
   :doc
   "Analyzes a whole namespace, returns a vector of the ASTs for all the\ntop-level ASTs of that namespace.",
   :var-type "function",
   :line 499,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:arglists ([]),
   :name "backup-env",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L531",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/backup-env",
   :doc
   "Caches the current namespaces state in a resource file, can be restored with\n(restore-env)",
   :var-type "function",
   :line 531,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:arglists ([]),
   :name "cljs-env->env",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L563",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/cljs-env->env",
   :doc
   "Converts the namespace map of the current cljs environment in a tools.analyzer.js\nnamespace map and returns it.",
   :var-type "function",
   :line 563,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:arglists ([sym {:keys [ns]}]),
   :name "create-var",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L187",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/create-var",
   :doc "Creates a var map for sym and returns it.",
   :var-type "function",
   :line 187,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:arglists ([]),
   :name "empty-env",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L68",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/empty-env",
   :doc "Returns an empty env map",
   :var-type "function",
   :line 68,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L50",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/parse",
   :namespace "clojure.tools.analyzer.js",
   :line 50,
   :var-type "multimethod",
   :doc "Extension to tools.analyzer/-parse for CLJS special forms",
   :name "parse"}
  {:arglists ([]),
   :name "restore-env",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L546",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/restore-env",
   :doc "Uses a cached env to populate the default namespace map",
   :var-type "function",
   :line 546,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:arglists ([ast]),
   :name "run-passes",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L426",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/run-passes",
   :doc
   "Applies the following passes in the correct order to the AST:\n* uniquify\n* add-binding-atom\n* source-info\n* elide-meta\n* warn-earmuff\n* js.collect-keywords\n* js.annotate-tag\n* js.analyze-host-expr\n* js.infer-tag\n* js.validate",
   :var-type "function",
   :line 426,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:arglists ([]),
   :name "setup-rt!",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L552",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/setup-rt!",
   :doc
   "Setups the basic runtime, loading cljs.core and initializing cljs.user",
   :var-type "function",
   :line 552,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/c2e9952c1af02d534e7897117f681a1333e2b3d3/src/main/clojure/clojure/tools/analyzer/js.clj#L46",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/specials",
   :namespace "clojure.tools.analyzer.js",
   :line 46,
   :var-type "var",
   :doc "Set of the special forms for clojurescript",
   :name "specials"}
  {:file
   "src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj#L13",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.analyze-host-expr-api.html#clojure.tools.analyzer.passes.js.analyze-host-expr/analyze-host-expr",
   :namespace "clojure.tools.analyzer.passes.js.analyze-host-expr",
   :line 13,
   :var-type "multimethod",
   :doc
   "Transform :host-interop nodes into :host-call, transform\n:maybe-class or :maybe-host-form nodes resolvable to js vars\ninto :js-var nodes",
   :name "analyze-host-expr"}
  {:arglists ([ast]),
   :name "annotate-tag",
   :namespace "clojure.tools.analyzer.passes.js.annotate-tag",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj#L80",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.annotate-tag-api.html#clojure.tools.analyzer.passes.js.annotate-tag/annotate-tag",
   :doc
   "If the AST node type is a constant object or contains :tag metadata,\nattach the appropriate :tag to the node.",
   :var-type "function",
   :line 80,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj"}
  {:arglists ([ast]),
   :name "collect-keywords",
   :namespace "clojure.tools.analyzer.passes.js.collect-keywords",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.collect-keywords-api.html#clojure.tools.analyzer.passes.js.collect-keywords/collect-keywords",
   :doc
   "Assoc compilation-unit shared id to each :const node with :type :keyword,\nThe keyword to id map is available in the global env under ::keywords",
   :var-type "function",
   :line 12,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj"}
  {:arglists ([ast] [ast opts]),
   :name "emit-form",
   :namespace "clojure.tools.analyzer.passes.js.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/54e429a472df4cc5cf512d4c7e1e06a343038d08/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj#L26",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/54e429a472df4cc5cf512d4c7e1e06a343038d08/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.emit-form-api.html#clojure.tools.analyzer.passes.js.emit-form/emit-form",
   :doc
   "Return the form represented by the given AST\nOpts is a set of options, valid options are:\n * :hygienic\n * :qualified-symbols",
   :var-type "function",
   :line 26,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj"}
  {:arglists ([ast]),
   :name "emit-hygienic-form",
   :namespace "clojure.tools.analyzer.passes.js.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/54e429a472df4cc5cf512d4c7e1e06a343038d08/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj#L36",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/54e429a472df4cc5cf512d4c7e1e06a343038d08/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.emit-form-api.html#clojure.tools.analyzer.passes.js.emit-form/emit-hygienic-form",
   :doc "Return an hygienic form represented by the given AST",
   :var-type "function",
   :line 36,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj"}
  {:arglists ([{:keys [tag], :as ast}]),
   :name "infer-tag",
   :namespace "clojure.tools.analyzer.passes.js.infer-tag",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/672f2964132b288d45861e42bfa0763ad17c2bf4/src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj#L179",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/672f2964132b288d45861e42bfa0763ad17c2bf4/src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.infer-tag-api.html#clojure.tools.analyzer.passes.js.infer-tag/infer-tag",
   :doc
   "Performs local type inference on the AST adds, when possible,\none or more of the following keys to the AST:\n* :tag        represents the type the expression represented by the node\n* :return-tag implies that the node will return a function whose\n              invocation will result in a object of this type\n* :arglists   implies that the node will return a function with\n              this arglists\n* :ignore-tag true when the node is untyped, does not imply that\n              all untyped node will have this",
   :var-type "function",
   :line 179,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj"}
  {:arglists ([ast]),
   :name "validate",
   :namespace "clojure.tools.analyzer.passes.js.validate",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj#L57",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/fcb8fe83af998825743606225de3c70919899eaa/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.validate-api.html#clojure.tools.analyzer.passes.js.validate/validate",
   :doc
   "Validate tags and symbols.\nThrows exceptions when invalid forms are encountered",
   :var-type "function",
   :line 57,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj"}
  {:arglists ([a idx ret expr]),
   :name "amap",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1448",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/amap",
   :doc
   "Maps an expression across an array a, using an index named idx, and\nreturn value named ret, initialized to a clone of a, then setting\neach element of ret to the evaluation of expr, returning the new\narray ret.",
   :var-type "macro",
   :line 1448,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([] [x] [x & next]),
   :name "and",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L239",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/and",
   :doc
   "Evaluates exprs one at a time, from left to right. If a form\nreturns logical false (nil or false), and returns that value and\ndoesn't evaluate any of the other expressions, otherwise it returns\nthe value of the last expr. (and) returns true.",
   :var-type "macro",
   :line 239,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([a idx ret init expr]),
   :name "areduce",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1463",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/areduce",
   :doc
   "Reduces an expression across an array a, using an index named idx,\nand return value named ret, initialized to init, setting ret to the\nevaluation of expr at each step, returning ret.",
   :var-type "macro",
   :line 1463,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([x] [x message]),
   :name "assert",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1186",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/assert",
   :doc
   "Evaluates expr and throws an exception if it does not evaluate to\nlogical true.",
   :var-type "macro",
   :line 1186,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([bindings & body]),
   :name "binding",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1072",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/binding",
   :doc
   "binding => var-symbol init-expr\n\nCreates new bindings for the (already-existing) vars, with the\nsupplied initial values, executes the exprs in an implicit do, then\nre-establishes the bindings that existed before.  The new bindings\nare made in parallel (unlike let); all init-exprs are evaluated\nbefore the vars are bound to their new values.",
   :var-type "macro",
   :line 1072,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([pred expr & clauses]),
   :name "condp",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1085",
   :added "1.0",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/condp",
   :doc
   "Takes a binary predicate, an expression, and a set of clauses.\nEach clause can take the form of either:\n\ntest-expr result-expr\n\ntest-expr :>> result-fn\n\nNote :>> is an ordinary keyword.\n\nFor each clause, (pred test-expr expr) is evaluated. If it returns\nlogical true, the clause is a match. If a binary clause matches, the\nresult-expr is returned, if a ternary clause matches, its result-fn,\nwhich must be a unary function, is called with the result of the\npredicate as its argument, the result of that call being the return\nvalue of condp. A single default expression can follow the clauses,\nand its value will be returned if no clause matches. If no default\nexpression is provided and no clause matches, an\nIllegalArgumentException is thrown.",
   :var-type "macro",
   :line 1085,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([multifn dispatch-val & fn-tail]),
   :name "defmethod",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1541",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/defmethod",
   :doc
   "Creates and installs a new method of multimethod associated with dispatch-value. ",
   :var-type "macro",
   :line 1541,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([mm-name & options]),
   :name "defmulti",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1498",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/defmulti",
   :doc
   "Creates a new multimethod with the associated dispatch function.\nThe docstring and attribute-map are optional.\n\nOptions are key-value pairs and may be one of:\n  :default    the default dispatch value, defaults to :default\n  :hierarchy  the isa? hierarchy to use for dispatching\n              defaults to the global hierarchy",
   :var-type "macro",
   :line 1498,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([seq-exprs & body]),
   :name "doseq",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1287",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/doseq",
   :doc
   "Repeatedly executes body (presumably for side-effects) with\nbindings and filtering as provided by \"for\".  Does not retain\nthe head of the sequence. Returns nil.",
   :var-type "macro",
   :line 1287,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([bindings & body]),
   :name "dotimes",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1474",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/dotimes",
   :doc
   "bindings => name n\n\nRepeatedly executes body (presumably for side-effects) with name\nbound to integers from 0 through n-1.",
   :var-type "macro",
   :line 1474,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L194",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/fast-path-protocol-partitions-count",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :line 194,
   :var-type "var",
   :doc "total number of partitions",
   :name "fast-path-protocol-partitions-count"}
  {:file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L178",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/fast-path-protocols",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :line 178,
   :var-type "var",
   :doc "protocol fqn -> [partition number, bit]",
   :name "fast-path-protocols"}
  {:arglists ([seq-exprs body-expr]),
   :name "for",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1200",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/for",
   :doc
   "List comprehension. Takes a vector of one or more\n binding-form/collection-expr pairs, each followed by zero or more\n modifiers, and yields a lazy sequence of evaluations of expr.\n Collections are iterated in a nested fashion, rightmost fastest,\n and nested coll-exprs can refer to bindings created in prior\n binding-forms.  Supported modifiers are: :let [binding-form expr ...],\n :while test, :when test.\n\n(take 100 (for [x (range 100000000) y (range 1000000) :while (< y x)]  [x y]))",
   :var-type "macro",
   :line 1200,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([psym x]),
   :name "implements?",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1002",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/implements?",
   :doc "EXPERIMENTAL",
   :var-type "macro",
   :line 1002,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([& colls]),
   :name "lazy-cat",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1610",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/lazy-cat",
   :doc
   "Expands to code which yields a lazy sequence of the concatenation\nof the supplied colls.  Each coll expr is not evaluated until it is\nneeded.\n\n(lazy-cat xs ys zs) === (concat (lazy-seq xs) (lazy-seq ys) (lazy-seq zs))",
   :var-type "macro",
   :line 1610,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([bindings & body]),
   :name "let",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L142",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/let",
   :doc
   "binding => binding-form init-expr\n\nEvaluates the exprs in a lexical context in which the symbols in\nthe binding-forms are bound to their respective init-exprs or parts\ntherein.",
   :var-type "macro",
   :line 142,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([bindings & body]),
   :name "loop",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L154",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/loop",
   :doc
   "Evaluates the exprs in a lexical context in which the symbols in\nthe binding-forms are bound to their respective init-exprs or parts\ntherein. Acts as a recur target.",
   :var-type "macro",
   :line 154,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([] [x] [x & next]),
   :name "or",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L257",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/or",
   :doc
   "Evaluates exprs one at a time, from left to right. If a form\nreturns a logical true value, or returns that value and doesn't\nevaluate any of the other expressions, otherwise it returns the\nvalue of the last expression. (or) returns nil.",
   :var-type "macro",
   :line 257,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([psym x]),
   :name "satisfies?",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1020",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/satisfies?",
   :doc "Returns true if x satisfies the protocol",
   :var-type "macro",
   :line 1020,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists
   ([bindings
     expr
     iterations
     &
     {:keys [print-fn], :or {print-fn 'println}}]),
   :name "simple-benchmark",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1554",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/simple-benchmark",
   :doc
   "Runs expr iterations times in the context of a let expression with\nthe given bindings, then prints out the bindings and the expr\nfollowed by number of iterations and total time. The optional\nargument print-fn, defaulting to println, sets function used to\nprint the result. expr's string representation will be produced\nusing pr-str in any case.",
   :var-type "macro",
   :line 1554,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([name & body]),
   :name "this-as",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L655",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/this-as",
   :doc
   "Defines a scope where JavaScript's implicit \"this\" is bound to the name provided.",
   :var-type "macro",
   :line 655,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([expr]),
   :name "time",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1546",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/time",
   :doc
   "Evaluates expr and prints the time it took. Returns the value of expr.",
   :var-type "macro",
   :line 1546,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([& body]),
   :name "with-out-str",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1600",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/with-out-str",
   :doc
   "Evaluates exprs in a context in which *print-fn* is bound to .append\non a fresh StringBuffer.  Returns the string created by any nested\nprinting calls.",
   :var-type "macro",
   :line 1600,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}
  {:arglists ([bindings & body]),
   :name "with-redefs",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1050",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/7e6d433d923a41b842fc65db64a2b8b51dbe7a85/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/with-redefs",
   :doc
   "binding => var-symbol temp-value-expr\n\nTemporarily redefines vars while executing the body.  The\ntemp-value-exprs will be evaluated and each resulting value will\nreplace in parallel the root value of its var.  After the body is\nexecuted, the root values of all the vars will be set back to their\nold values. Useful for mocking out functions during testing.",
   :var-type "macro",
   :line 1050,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"})}
