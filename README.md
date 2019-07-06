# spa-spring-vue
A Basic SpringMVC web application configured for a VueJS single page client application.

Why is this so hard? Seriously?!

The end result is really simple but getting to this point is really not. Don't believe me? Well you're here
aren't you. Just try and work it all out yourself before looking at this code, you'll understand the misery.

This project uses VueJS, using ReactJS or any other client framework should be very similar.

If you're looking for an equivalent ReactJS version, check out [spa-spring-react](https://github.com/caprica/spa-spring-react).

If you're looking for an equivalent AngularJS version, check out [spa-spring-angular](https://github.com/caprica/spa-spring-angular).

Anyway, here it is, a skeleton project for a single page web application using SpringMVC for the middle tier.

Key features:

 * The web application is mapped to the root "/" context
 * All static resources are under the "/assets/" path
 * A request for "index.html" will redirect to "/" for a nicer URL in the address bar
 * All web-service API are under an "/api/" path
 * A request for an unknown API will have a catch-all that maps to a BAD_REQUEST response
 * Any other request, including deep-link requests, will map to the single page web application for client
   routing
 * Does NOT rely on ugly hashes '#' in URLs or the address bar 
 * Works with @EnableWebMvc, if you don't use this annotation you will need to set up some other things manually.

The names for the path prefixes used are arbitrary and can be changed to whatever you prefer.

There is no cache control for the static resources, you might like to consider that.

You can run this project from a shell/terminal, simply type:

```
mvn jetty:run
```

To change the port number used by Jetty:

```
mvn jetty:run -Djetty.port=9090
```

Then open your browser at the following URLs to prove it's all configured properly:

```
http://localhost:8080
http://localhost:8080/index.html
http://localhost:8080/api/users
http://localhost:8080/api/users/boss
http://localhost:8080/api/users/emo
http://localhost:8080/api/users/emma
http://localhost:8080/api/version
http://localhost:8080/api/anything-else-does-not-exist
http://localhost:8080/assets/css/index.css
http://localhost:8080/assets/img/star.png
http://localhost:8080/assets/js/app.js
```

It can still be useful to route to static assets on the server - e.g. images or scripts that not part of the client
application itself.

This project also has client-side routing enabled. These are deep links that will be routed to the client index
page where the Vue router will take over:

```
http://localhost:8080/users
http://localhost:8080/users/boss
http://localhost:8080/users/emo
http://localhost:8080/users/emma
http://localhost:8080/a/not/found/page
```

Full refreshes will work and be routed correctly.

Everything else is just like any other VueJS application.

If you want to disable source maps in Production, add the following to a vue.config.js file in the same directory as the
package.json file:

```
module.exports = {
  productionSourceMap: false
};
```

Proxying API requests also works just the same as before, add the following to a vue.config.js file in the same
directory as the package.json file (this has already been applied in this project):

```
module.exports = {
  devServer: {
    proxy: 'http://localhost:8080'
  }
}
``` 

You may need to adjust the port number, in this case 8080 is the port number used by the Jetty container launched
by the aforementioned maven command.

And then as usual to run the development version of the application (use port 3000 rather than 8080):

```
cd src/main/app
yarn serve
```
 
You're welcome.
