{:namespaces
 ({:doc
   "Analyzer for clojurescript code, extends tools.analyzer with JS specific passes/forms",
   :name "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js/js-api.html#clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj"}
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
   "https://github.com/clojure/tools.analyzer.js/blob/fe540b1ed077e8afb2991da98ea08be1fd9dfa5d/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj"}
  {:doc nil,
   :name "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js/js-api.html#clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"}),
 :vars
 ({:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "analyze",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L455",
   :line 455,
   :var-type "function",
   :arglists ([form] [form env] [form env opts]),
   :doc
   "Returns an AST for the form.\n\nBinds tools.analyzer/{macroexpand-1,create-var,parse} to\ntools.analyzer.js/{macroexpand-1,create-var,parse} and analyzes the form.\n\nIf provided, opts should be a map of options to analyze, currently the only valid\noptions are :bindings and :passes-opts.\nIf provided, :bindings should be a map of Var->value pairs that will be merged into the\ndefault bindings for tools.analyzer, useful to provide custom extension points.\nIf provided, :passes-opts should be a map of pass-name-kw->pass-config-map pairs that\ncan be used to configure the behaviour of each pass.\n\nE.g.\n(analyze form env {:bindings  {#'ana/macroexpand-1 my-mexpand-1}})\n\nCalls `run-passes` on the AST.",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/analyze"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "analyze-ns",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L490",
   :line 490,
   :var-type "function",
   :arglists ([ns]),
   :doc
   "Analyzes a whole namespace, returns a vector of the ASTs for all the\ntop-level ASTs of that namespace.",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/analyze-ns"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "backup-env",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L522",
   :line 522,
   :var-type "function",
   :arglists ([]),
   :doc
   "Caches the current namespaces state in a resource file, can be restored with\n(restore-env)",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/backup-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "cljs-env->env",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L554",
   :line 554,
   :var-type "function",
   :arglists ([]),
   :doc
   "Converts the namespace map of the current cljs environment in a tools.analyzer.js\nnamespace map and returns it.",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/cljs-env->env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "create-var",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L190",
   :line 190,
   :var-type "function",
   :arglists ([sym {:keys [ns]}]),
   :doc "Creates a var map for sym and returns it.",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/create-var"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "default-passes",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L432",
   :line 432,
   :var-type "var",
   :arglists nil,
   :doc
   "Set of passes that will be run by default on the AST by #'run-passes",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/default-passes"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "empty-env",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L71",
   :line 71,
   :var-type "function",
   :arglists ([]),
   :doc "Returns an empty env map",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/empty-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "parse",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L52",
   :line 52,
   :var-type "multimethod",
   :arglists nil,
   :doc "Extension to tools.analyzer/-parse for CLJS special forms",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/parse"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "restore-env",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L537",
   :line 537,
   :var-type "function",
   :arglists ([]),
   :doc "Uses a cached env to populate the default namespace map",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/restore-env"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "run-passes",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L449",
   :dynamic true,
   :line 449,
   :var-type "function",
   :arglists ([ast]),
   :doc
   "Function that will be invoked on the AST tree immediately after it has been constructed,\nby default set-ups and runs the default passes declared in #'default-passes",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/run-passes"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "setup-rt!",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L543",
   :line 543,
   :var-type "function",
   :arglists ([]),
   :doc
   "Setups the basic runtime, loading cljs.core and initializing cljs.user",
   :namespace "clojure.tools.analyzer.js",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/setup-rt!"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :name "specials",
   :file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/a1cd6e87d46e238db65feb9b3797c897f47e1d10/src/main/clojure/clojure/tools/analyzer/js.clj#L48",
   :line 48,
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
   "http://clojure.github.io/tools.analyzer.js//passes.js.validate-api.html#clojure.tools.analyzer.passes.js.validate/validate"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "amap",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1501",
   :line 1501,
   :var-type "macro",
   :arglists ([a idx ret expr]),
   :doc
   "Maps an expression across an array a, using an index named idx, and\nreturn value named ret, initialized to a clone of a, then setting\neach element of ret to the evaluation of expr, returning the new\narray ret.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/amap"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "and",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L223",
   :line 223,
   :var-type "macro",
   :arglists ([] [x] [x & next]),
   :doc
   "Evaluates exprs one at a time, from left to right. If a form\nreturns logical false (nil or false), and returns that value and\ndoesn't evaluate any of the other expressions, otherwise it returns\nthe value of the last expr. (and) returns true.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/and"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "areduce",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1516",
   :line 1516,
   :var-type "macro",
   :arglists ([a idx ret init expr]),
   :doc
   "Reduces an expression across an array a, using an index named idx,\nand return value named ret, initialized to init, setting ret to the\nevaluation of expr at each step, returning ret.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/areduce"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "assert",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1245",
   :line 1245,
   :var-type "macro",
   :arglists ([x] [x message]),
   :doc
   "Evaluates expr and throws an exception if it does not evaluate to\nlogical true.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/assert"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "binding",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1131",
   :line 1131,
   :var-type "macro",
   :arglists ([bindings & body]),
   :doc
   "binding => var-symbol init-expr\n\nCreates new bindings for the (already-existing) vars, with the\nsupplied initial values, executes the exprs in an implicit do, then\nre-establishes the bindings that existed before.  The new bindings\nare made in parallel (unlike let); all init-exprs are evaluated\nbefore the vars are bound to their new values.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/binding"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :added "1.0",
   :name "condp",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1144",
   :line 1144,
   :var-type "macro",
   :arglists ([pred expr & clauses]),
   :doc
   "Takes a binary predicate, an expression, and a set of clauses.\nEach clause can take the form of either:\n\ntest-expr result-expr\n\ntest-expr :>> result-fn\n\nNote :>> is an ordinary keyword.\n\nFor each clause, (pred test-expr expr) is evaluated. If it returns\nlogical true, the clause is a match. If a binary clause matches, the\nresult-expr is returned, if a ternary clause matches, its result-fn,\nwhich must be a unary function, is called with the result of the\npredicate as its argument, the result of that call being the return\nvalue of condp. A single default expression can follow the clauses,\nand its value will be returned if no clause matches. If no default\nexpression is provided and no clause matches, an\nIllegalArgumentException is thrown.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/condp"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "defmethod",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1595",
   :line 1595,
   :var-type "macro",
   :arglists ([multifn dispatch-val & fn-tail]),
   :doc
   "Creates and installs a new method of multimethod associated with dispatch-value. ",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/defmethod"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "defmulti",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1551",
   :line 1551,
   :var-type "macro",
   :arglists ([mm-name & options]),
   :doc
   "Creates a new multimethod with the associated dispatch function.\nThe docstring and attribute-map are optional.\n\nOptions are key-value pairs and may be one of:\n  :default    the default dispatch value, defaults to :default\n  :hierarchy  the isa? hierarchy to use for dispatching\n              defaults to the global hierarchy",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/defmulti"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "doseq",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1346",
   :line 1346,
   :var-type "macro",
   :arglists ([seq-exprs & body]),
   :doc
   "Repeatedly executes body (presumably for side-effects) with\nbindings and filtering as provided by \"for\".  Does not retain\nthe head of the sequence. Returns nil.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/doseq"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "dotimes",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1527",
   :line 1527,
   :var-type "macro",
   :arglists ([bindings & body]),
   :doc
   "bindings => name n\n\nRepeatedly executes body (presumably for side-effects) with name\nbound to integers from 0 through n-1.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/dotimes"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "fast-path-protocol-partitions-count",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L201",
   :line 201,
   :var-type "var",
   :arglists nil,
   :doc "total number of partitions",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/fast-path-protocol-partitions-count"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "fast-path-protocols",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L184",
   :line 184,
   :var-type "var",
   :arglists nil,
   :doc "protocol fqn -> [partition number, bit]",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/fast-path-protocols"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "for",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1259",
   :line 1259,
   :var-type "macro",
   :arglists ([seq-exprs body-expr]),
   :doc
   "List comprehension. Takes a vector of one or more\n binding-form/collection-expr pairs, each followed by zero or more\n modifiers, and yields a lazy sequence of evaluations of expr.\n Collections are iterated in a nested fashion, rightmost fastest,\n and nested coll-exprs can refer to bindings created in prior\n binding-forms.  Supported modifiers are: :let [binding-form expr ...],\n :while test, :when test.\n\n(take 100 (for [x (range 100000000) y (range 1000000) :while (< y x)]  [x y]))",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/for"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "implements?",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1061",
   :line 1061,
   :var-type "macro",
   :arglists ([psym x]),
   :doc "EXPERIMENTAL",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/implements?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "lazy-cat",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1663",
   :line 1663,
   :var-type "macro",
   :arglists ([& colls]),
   :doc
   "Expands to code which yields a lazy sequence of the concatenation\nof the supplied colls.  Each coll expr is not evaluated until it is\nneeded.\n\n(lazy-cat xs ys zs) === (concat (lazy-seq xs) (lazy-seq ys) (lazy-seq zs))",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/lazy-cat"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "let",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L148",
   :line 148,
   :var-type "macro",
   :arglists ([bindings & body]),
   :doc
   "binding => binding-form init-expr\n\nEvaluates the exprs in a lexical context in which the symbols in\nthe binding-forms are bound to their respective init-exprs or parts\ntherein.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/let"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "loop",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L160",
   :line 160,
   :var-type "macro",
   :arglists ([bindings & body]),
   :doc
   "Evaluates the exprs in a lexical context in which the symbols in\nthe binding-forms are bound to their respective init-exprs or parts\ntherein. Acts as a recur target.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/loop"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "ns-interns",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1681",
   :line 1681,
   :var-type "macro",
   :arglists ([[quote ns]]),
   :doc "Returns a map of the intern mappings for the namespace.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/ns-interns"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "or",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L241",
   :line 241,
   :var-type "macro",
   :arglists ([] [x] [x & next]),
   :doc
   "Evaluates exprs one at a time, from left to right. If a form\nreturns a logical true value, or returns that value and doesn't\nevaluate any of the other expressions, otherwise it returns the\nvalue of the last expression. (or) returns nil.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/or"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "satisfies?",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1079",
   :line 1079,
   :var-type "macro",
   :arglists ([psym x]),
   :doc "Returns true if x satisfies the protocol",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/satisfies?"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "simple-benchmark",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1608",
   :line 1608,
   :var-type "macro",
   :arglists
   ([bindings
     expr
     iterations
     &
     {:keys [print-fn], :or {print-fn 'println}}]),
   :doc
   "Runs expr iterations times in the context of a let expression with\nthe given bindings, then prints out the bindings and the expr\nfollowed by number of iterations and total time. The optional\nargument print-fn, defaulting to println, sets function used to\nprint the result. expr's string representation will be produced\nusing pr-str in any case.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/simple-benchmark"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "this-as",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L642",
   :line 642,
   :var-type "macro",
   :arglists ([name & body]),
   :doc
   "Defines a scope where JavaScript's implicit \"this\" is bound to the name provided.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/this-as"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "time",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1600",
   :line 1600,
   :var-type "macro",
   :arglists ([expr]),
   :doc
   "Evaluates expr and prints the time it took. Returns the value of expr.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/time"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "with-out-str",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1653",
   :line 1653,
   :var-type "macro",
   :arglists ([& body]),
   :doc
   "Evaluates exprs in a context in which *print-fn* is bound to .append\non a fresh StringBuffer.  Returns the string created by any nested\nprinting calls.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/with-out-str"}
  {:raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :name "with-redefs",
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/6b25c0613822cec75683797d8fd8e987dc279714/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L1109",
   :line 1109,
   :var-type "macro",
   :arglists ([bindings & body]),
   :doc
   "binding => var-symbol temp-value-expr\n\nTemporarily redefines vars while executing the body.  The\ntemp-value-exprs will be evaluated and each resulting value will\nreplace in parallel the root value of its var.  After the body is\nexecuted, the root values of all the vars will be set back to their\nold values. Useful for mocking out functions during testing.",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :wiki-url
   "http://clojure.github.io/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/with-redefs"})}
