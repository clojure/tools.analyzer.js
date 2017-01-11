{:namespaces
 ({:doc
   "Analyzer for clojurescript code, extends tools.analyzer with JS specific passes/forms",
   :name "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js/js-api.html#clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.js.analyze-host-expr",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js/passes.js.analyze-host-expr-api.html#clojure.tools.analyzer.passes.js.analyze-host-expr",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fe540b1ed077e8afb2991da98ea08be1fd9dfa5d/src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.js.annotate-tag",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js/passes.js.annotate-tag-api.html#clojure.tools.analyzer.passes.js.annotate-tag",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.js.collect-keywords",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js/passes.js.collect-keywords-api.html#clojure.tools.analyzer.passes.js.collect-keywords",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.js.emit-form",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js/passes.js.emit-form-api.html#clojure.tools.analyzer.passes.js.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/2372c069772168d7c6c46a53c7fce8bcb795cd1e/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.js.infer-tag",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js/passes.js.infer-tag-api.html#clojure.tools.analyzer.passes.js.infer-tag",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.passes.js.validate",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js/passes.js.validate-api.html#clojure.tools.analyzer.passes.js.validate",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fe540b1ed077e8afb2991da98ea08be1fd9dfa5d/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj"}),
 :vars
 ({:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "analyze",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L456",
   :line 456,
   :var-type "function",
   :arglists ([form] [form env] [form env opts]),
   :doc
   "Returns an AST for the form.\n\nBinds tools.analyzer/{macroexpand-1,create-var,parse} to\ntools.analyzer.js/{macroexpand-1,create-var,parse} and analyzes the form.\n\nIf provided, opts should be a map of options to analyze, currently the only valid\noptions are :bindings and :passes-opts.\nIf provided, :bindings should be a map of Var->value pairs that will be merged into the\ndefault bindings for tools.analyzer, useful to provide custom extension points.\nIf provided, :passes-opts should be a map of pass-name-kw->pass-config-map pairs that\ncan be used to configure the behaviour of each pass.\n\nE.g.\n(analyze form env {:bindings  {#'ana/macroexpand-1 my-mexpand-1}})\n\nCalls `run-passes` on the AST.",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/analyze"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "analyze-ns",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L491",
   :line 491,
   :var-type "function",
   :arglists ([ns]),
   :doc
   "Analyzes a whole namespace, returns a vector of the ASTs for all the\ntop-level ASTs of that namespace.",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/analyze-ns"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "backup-env",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L523",
   :line 523,
   :var-type "function",
   :arglists ([]),
   :doc
   "Caches the current namespaces state in a resource file, can be restored with\n(restore-env)",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/backup-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "cljs-env->env",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L555",
   :line 555,
   :var-type "function",
   :arglists ([]),
   :doc
   "Converts the namespace map of the current cljs environment in a tools.analyzer.js\nnamespace map and returns it.",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/cljs-env->env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "create-var",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L191",
   :line 191,
   :var-type "function",
   :arglists ([sym {:keys [ns]}]),
   :doc "Creates a var map for sym and returns it.",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/create-var"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "default-passes",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L433",
   :line 433,
   :var-type "var",
   :arglists nil,
   :doc
   "Set of passes that will be run by default on the AST by #'run-passes",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/default-passes"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "empty-env",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L72",
   :line 72,
   :var-type "function",
   :arglists ([]),
   :doc "Returns an empty env map",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/empty-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "parse",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L53",
   :line 53,
   :var-type "multimethod",
   :arglists nil,
   :doc "Extension to tools.analyzer/-parse for CLJS special forms",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/parse"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "restore-env",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L538",
   :line 538,
   :var-type "function",
   :arglists ([]),
   :doc "Uses a cached env to populate the default namespace map",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/restore-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "run-passes",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L450",
   :dynamic true,
   :line 450,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Function that will be invoked on the AST tree immediately after it has been constructed,\nby default set-ups and runs the default passes declared in #'default-passes",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/run-passes"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "setup-rt!",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L544",
   :line 544,
   :var-type "function",
   :arglists ([]),
   :doc
   "Setups the basic runtime, loading cljs.core and initializing cljs.user",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/setup-rt!"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "specials",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/62f87352c61213301dfb067e4714ee104f71e00f/src/main/clojure/clojure/tools/analyzer/js.clj#L49",
   :line 49,
   :var-type "var",
   :arglists nil,
   :doc "Set of the special forms for clojurescript",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/specials"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/fe540b1ed077e8afb2991da98ea08be1fd9dfa5d/src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj",
   :name "analyze-host-expr",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fe540b1ed077e8afb2991da98ea08be1fd9dfa5d/src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj#L13",
   :line 13,
   :var-type "multimethod",
   :arglists nil,
   :doc
   "Transform :host-interop nodes into :host-call, transform\n:maybe-class or :maybe-host-form nodes resolvable to js vars\ninto :js-var nodes",
   :namespace "clojure.tools.analyzer.passes.js.analyze-host-expr",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//passes.js.analyze-host-expr-api.html#clojure.tools.analyzer.passes.js.analyze-host-expr/analyze-host-expr"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj",
   :name "annotate-tag",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj#L80",
   :line 80,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "If the AST node type is a constant object or contains :tag metadata,\nattach the appropriate :tag to the node.",
   :namespace "clojure.tools.analyzer.passes.js.annotate-tag",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//passes.js.annotate-tag-api.html#clojure.tools.analyzer.passes.js.annotate-tag/annotate-tag"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj",
   :name "collect-keywords",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj#L13",
   :line 13,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Assoc compilation-unit shared id to each :const node with :type :keyword,\nThe keyword to id map is available in the global env under ::keywords",
   :namespace "clojure.tools.analyzer.passes.js.collect-keywords",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//passes.js.collect-keywords-api.html#clojure.tools.analyzer.passes.js.collect-keywords/collect-keywords"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/2372c069772168d7c6c46a53c7fce8bcb795cd1e/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :name "emit-form",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/2372c069772168d7c6c46a53c7fce8bcb795cd1e/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj#L28",
   :line 28,
   :var-type "function",
   :arglists ([ast] [ast opts]),
   :doc
   "Return the form represented by the given AST\nOpts is a set of options, valid options are:\n * :hygienic\n * :qualified-symbols",
   :namespace "clojure.tools.analyzer.passes.js.emit-form",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//passes.js.emit-form-api.html#clojure.tools.analyzer.passes.js.emit-form/emit-form"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/2372c069772168d7c6c46a53c7fce8bcb795cd1e/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :name "emit-hygienic-form",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/2372c069772168d7c6c46a53c7fce8bcb795cd1e/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj#L39",
   :line 39,
   :var-type "function",
   :arglists ([ast]),
   :doc "Return an hygienic form represented by the given AST",
   :namespace "clojure.tools.analyzer.passes.js.emit-form",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//passes.js.emit-form-api.html#clojure.tools.analyzer.passes.js.emit-form/emit-hygienic-form"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj",
   :name "infer-tag",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj#L183",
   :line 183,
   :var-type "function",
   :arglists ([{:keys [tag], :as ast}]),
   :doc
   "Performs local type inference on the AST adds, when possible,\none or more of the following keys to the AST:\n* :tag        represents the type the expression represented by the node\n* :return-tag implies that the node will return a function whose\n              invocation will result in a object of this type\n* :arglists   implies that the node will return a function with\n              this arglists\n* :ignore-tag true when the node is untyped, does not imply that\n              all untyped node will have this",
   :namespace "clojure.tools.analyzer.passes.js.infer-tag",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//passes.js.infer-tag-api.html#clojure.tools.analyzer.passes.js.infer-tag/infer-tag"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/fe540b1ed077e8afb2991da98ea08be1fd9dfa5d/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj",
   :name "validate",
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/fe540b1ed077e8afb2991da98ea08be1fd9dfa5d/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj#L58",
   :line 58,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Validate tags and symbols.\nThrows exceptions when invalid forms are encountered",
   :namespace "clojure.tools.analyzer.passes.js.validate",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//passes.js.validate-api.html#clojure.tools.analyzer.passes.js.validate/validate"})}
