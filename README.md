# tools.analyzer.js

Provides js-specific passes for tools.analyzer

# ABANDONED

The last version of `tools.analyzer.js` works with a very ancient version of `clojurescript`.
This project should be considered abandoned as the official maintainer doesn't have time to update it to a newer one.

* [Example Usage](#example-usage)
* [AST Quickref](#ast-quickref)
* [Releases and Dependency Information](#releases-and-dependency-information)
* [Changelog](#changelog)
* [API Index](#api-index)
* [Developer Information](#developer-information)
* [License](#license)

## Example Usage

```clojure
user> (require '[clojure.tools.analyzer.js :as a]
               '[clojure.tools.analyzer.env :as env)
nil
user> (def env (a/global-env))
#'user/env
user> (env/with-env env (a/analyze 1))
{:op        :const,
 :top-level true,
 :tag       number,
 :env       {:context :ctx/statement, :locals {}, :ns cljs.user},
 :type      :number,
 :literal?  true,
 :val       1,
 :form      1}
user> (env/with-env env (a/analyze-ns 'cljs.core))
[{:op :ns ..}
 {:op :def ..}
 ..]
```

If `clojure.tools.analyzer.js` is used inside a cljs macro being expanded by `cljs.analyzer`, you can use `cljs-env->env` to populate tools.analyzer.js' global env from clojure.analyzer's one:
```clojure
clojure.tools.analyzer.js> (env/ensure (env/with-env (merge (env/deref-env)
                                                            {:namespaces (cljs-env->env)}))
                                       ..)
```

[AST Quickref](http://clojure.github.io/tools.analyzer.js/spec/quickref.html)
========================================

Releases and Dependency Information
========================================

Latest stable release: 0.1.0-beta5

* [All Released Versions](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.clojure%22%20AND%20a%3A%22tools.analyzer.js%22)

* [Development Snapshot Versions](https://oss.sonatype.org/index.html#nexus-search;gav%7Eorg.clojure%7Etools.analyzer.js%7E%7E%7E)

[Leiningen](https://github.com/technomancy/leiningen) dependency information:

```clojure
[org.clojure/tools.analyzer.js "0.1.0-beta5"]
```
[Maven](http://maven.apache.org/) dependency information:

```xml
<dependency>
  <groupId>org.clojure</groupId>
  <artifactId>tools.analyzer.js</artifactId>
  <version>0.1.0-beta5</version>
</dependency>
```

[Changelog](CHANGELOG.md)
========================================

API Index
========================================

* [CrossClj Documentation](http://crossclj.info/doc/org.clojure/tools.analyzer.js/lastest/index.html)
* [API index](http://clojure.github.io/tools.analyzer.js)

Developer Information
========================================

* [GitHub project](https://github.com/clojure/tools.analyzer.js)

* [Bug Tracker](http://dev.clojure.org/jira/browse/TANAL)

* [Continuous Integration](http://build.clojure.org/job/tools.analyzer.js/)

* [Compatibility Test Matrix](http://build.clojure.org/job/tools.analyzer.js-test-matrix/)

## License

Copyright © 2014 Nicola Mometto, Rich Hickey & contributors.

Distributed under the Eclipse Public License, the same as Clojure.
