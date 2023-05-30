# trinity-wizards-app-test

## Preparation for the test:
    - Commonly used Git workflow - we will have production branch and development branch.
        in our case: main is production, and dev is development branch.
    - App should be able to connect to the Internet so we need Internet permission.
    - This app is MVVM architecture. MVVM stands for Model View View Model. This architecture is recommended by Google.
    - Build Varaints: I created two Flavors 1) production, 2) development
        1) production flavor, we can generate prod configurations and apk
        2) development flaovr, we can have different configurations and different build for dev.
        we can configure endpoints to two different servers, one for prod, one for dev.
    - Added Retrofit and Moshi convertor:
        It is very common that the app has to talk to API or doing CRUD operations over the Internet.
    - Network or I/O operations should be done in the background with Kotlin coroutines
        Coroutines help to not block UIs threads on Android.
    - Firebase:
        I have integrated with Firebase, we can use Firebase remote config to force Users to update our app when there is a new release.
        Firebase provides many free features that we can make use of.
    - Added Material design color and dimension
