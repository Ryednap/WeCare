# WeCare
An IoT functional android application to  help in day-to-day medication and health routine.

![Red text](http://placehold.it/size/background-hex/foreground-hex?text=a123)Currently Under Development

The project contains 4 modules (hardware [arduino, node-mcu], analytics, backend, application).
However some components need still to be completed, apart from cloud deployement. Here's the status of each module.

* ***Hardware*** ✔️
* ***Analytics*** ✔️
* ***Backend*** ✖️ (analytics still isn't integrated problem with DJL so for temprorary workaround ``HealthService`` delgates work to external flask server which hosts the DL model).
* ***Application*** ✖️ (``HealthService`` left to be integrated along with minor fixes)

## How To Build ❓

Clone the repository and follow how to build each module seperately. </br>
Note that ***Hardware** and ***Analytics*** don't need any configuration, however being in development phase, in order to build **application** and **server** heavy configuration is needed. Once deployed on Cloud things will become much easire.
