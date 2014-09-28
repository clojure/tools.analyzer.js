{:namespaces
 ({:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/0a7a6e680ecc611a116eef633d50b164a5492b10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url "http://clojure.github.com/tools.analyzer.js/js-api.html",
   :name "clojure.tools.analyzer.js",
   :doc
   "Analyzer for clojurescript code, extends tools.analyzer with JS specific passes/forms"}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.analyze-host-expr-api.html",
   :name "clojure.tools.analyzer.passes.js.analyze-host-expr",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.annotate-tag-api.html",
   :name "clojure.tools.analyzer.passes.js.annotate-tag",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.collect-keywords-api.html",
   :name "clojure.tools.analyzer.passes.js.collect-keywords",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.emit-form-api.html",
   :name "clojure.tools.analyzer.passes.js.emit-form",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.infer-tag-api.html",
   :name "clojure.tools.analyzer.passes.js.infer-tag",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/passes.js.validate-api.html",
   :name "clojure.tools.analyzer.passes.js.validate",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer.js/blob/36eb175981d28b364e974d335b738caf0c85f3e4/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js/js.cljs.core-api.html",
   :name "clojure.tools.analyzer.js.cljs.core",
   :doc nil}),
 :vars
 ({:arglists ([sym {:keys [ns]}]),
   :name "create-var",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/0a7a6e680ecc611a116eef633d50b164a5492b10/src/main/clojure/clojure/tools/analyzer/js.clj#L188",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/0a7a6e680ecc611a116eef633d50b164a5492b10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/create-var",
   :doc "Creates a var map for sym and returns it.",
   :var-type "function",
   :line 188,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:arglists ([]),
   :name "empty-env",
   :namespace "clojure.tools.analyzer.js",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/0a7a6e680ecc611a116eef633d50b164a5492b10/src/main/clojure/clojure/tools/analyzer/js.clj#L69",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/0a7a6e680ecc611a116eef633d50b164a5492b10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/empty-env",
   :doc "Returns an empty env map",
   :var-type "function",
   :line 69,
   :file "src/main/clojure/clojure/tools/analyzer/js.clj"}
  {:file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/0a7a6e680ecc611a116eef633d50b164a5492b10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/0a7a6e680ecc611a116eef633d50b164a5492b10/src/main/clojure/clojure/tools/analyzer/js.clj#L51",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/parse",
   :namespace "clojure.tools.analyzer.js",
   :line 51,
   :var-type "multimethod",
   :doc "Extension to tools.analyzer/-parse for CLJS special forms",
   :name "parse"}
  {:file "src/main/clojure/clojure/tools/analyzer/js.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/0a7a6e680ecc611a116eef633d50b164a5492b10/src/main/clojure/clojure/tools/analyzer/js.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/0a7a6e680ecc611a116eef633d50b164a5492b10/src/main/clojure/clojure/tools/analyzer/js.clj#L47",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js/specials",
   :namespace "clojure.tools.analyzer.js",
   :line 47,
   :var-type "var",
   :doc "Set of the special forms for clojurescript",
   :name "specials"}
  {:file
   "src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/analyze_host_expr.clj#L13",
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
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj#L80",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/annotate_tag.clj",
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
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj#L13",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.collect-keywords-api.html#clojure.tools.analyzer.passes.js.collect-keywords/collect-keywords",
   :doc
   "Assoc compilation-unit shared id to each :const node with :type :keyword,\nThe keyword to id map is available in the global env under ::keywords",
   :var-type "function",
   :line 13,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/collect_keywords.clj"}
  {:arglists ([ast] [ast opts]),
   :name "emit-form",
   :namespace "clojure.tools.analyzer.passes.js.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj#L28",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.emit-form-api.html#clojure.tools.analyzer.passes.js.emit-form/emit-form",
   :doc
   "Return the form represented by the given AST\nOpts is a set of options, valid options are:\n * :hygienic\n * :qualified-symbols",
   :var-type "function",
   :line 28,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj"}
  {:arglists ([ast]),
   :name "emit-hygienic-form",
   :namespace "clojure.tools.analyzer.passes.js.emit-form",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj#L39",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.emit-form-api.html#clojure.tools.analyzer.passes.js.emit-form/emit-hygienic-form",
   :doc "Return an hygienic form represented by the given AST",
   :var-type "function",
   :line 39,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/emit_form.clj"}
  {:arglists ([{:keys [tag], :as ast}]),
   :name "infer-tag",
   :namespace "clojure.tools.analyzer.passes.js.infer-tag",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj#L183",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.infer-tag-api.html#clojure.tools.analyzer.passes.js.infer-tag/infer-tag",
   :doc
   "Performs local type inference on the AST adds, when possible,\none or more of the following keys to the AST:\n* :tag        represents the type the expression represented by the node\n* :return-tag implies that the node will return a function whose\n              invocation will result in a object of this type\n* :arglists   implies that the node will return a function with\n              this arglists\n* :ignore-tag true when the node is untyped, does not imply that\n              all untyped node will have this",
   :var-type "function",
   :line 183,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/infer_tag.clj"}
  {:arglists ([ast]),
   :name "validate",
   :namespace "clojure.tools.analyzer.passes.js.validate",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj#L58",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/f675b7b1084ce5ad4fc8241d12138fe26b025c80/src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//passes.js.validate-api.html#clojure.tools.analyzer.passes.js.validate/validate",
   :doc
   "Validate tags and symbols.\nThrows exceptions when invalid forms are encountered",
   :var-type "function",
   :line 58,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/js/validate.clj"}
  {:file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/36eb175981d28b364e974d335b738caf0c85f3e4/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/36eb175981d28b364e974d335b738caf0c85f3e4/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L194",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/fast-path-protocol-partitions-count",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :line 194,
   :var-type "var",
   :doc "total number of partitions",
   :name "fast-path-protocol-partitions-count"}
  {:file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/36eb175981d28b364e974d335b738caf0c85f3e4/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/36eb175981d28b364e974d335b738caf0c85f3e4/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L178",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/fast-path-protocols",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :line 178,
   :var-type "var",
   :doc "protocol fqn -> [partition number, bit]",
   :name "fast-path-protocols"}
  {:arglists ([bindings & body]),
   :name "let",
   :namespace "clojure.tools.analyzer.js.cljs.core",
   :source-url
   "https://github.com/clojure/tools.analyzer.js/blob/36eb175981d28b364e974d335b738caf0c85f3e4/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L142",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/36eb175981d28b364e974d335b738caf0c85f3e4/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
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
   "https://github.com/clojure/tools.analyzer.js/blob/36eb175981d28b364e974d335b738caf0c85f3e4/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj#L154",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer.js/raw/36eb175981d28b364e974d335b738caf0c85f3e4/src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer.js//js-api.html#clojure.tools.analyzer.js.cljs.core/loop",
   :doc
   "Evaluates the exprs in a lexical context in which the symbols in\nthe binding-forms are bound to their respective init-exprs or parts\ntherein. Acts as a recur target.",
   :var-type "macro",
   :line 154,
   :file "src/main/clojure/clojure/tools/analyzer/js/cljs/core.clj"})}
