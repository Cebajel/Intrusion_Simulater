# Intrusion_Simulater
This repository is about simulation of border intrusion between two countries, considering infinite border and input width.

## Prerequisites
Java Version : >= 17 \
Verified on **java 17.0.8 2023-07-18 LTS**.

## Setting up The Simulater
1. Download the **_insturion_simulater_** folder and create another folder wherever you like on your computer to store ".class" files of this project.
2. Open terminal at the folder you created to store ".class" files.
3. Run command mentioned below in your terminal after replacing \<path of intrusion_simulater> with actual path of **_intrusion_simulater_** on your computer.

```
javac -d . <path of intrusion_simulater>/*.java 
```

By now you should have another folder named "intrusion_simulater" inside your new folder containing ".class" files of this project. If you can not find "intrusion_simulater"
in your created folder then you should check the steps you have performed and see if they align with aforementioned instructions.

## Running the Simulation
Just run following command from terminal at your new folder :
```
java instrusion_simulater.Simulater
```

Program will ask for the width of the border, enter any natural integer as width of border. 
After that program will ask for a boolean value if user wants to consider cell in analysis of the intruder while making decisions. Enter "true" if you want to else enter "false".

## Output
- Program will print out values of X1, Y1, X2, and Y2. (X1, Y1) are the current coordinates of the infiltrator and (X2, Y2) are coordinates on which he has decided to go. Intruder will get caught if sensor on any of these coordinates will get activated. Program will also print out if sensors are active or not on (X1, Y1) and (X2, Y2).
- Program will print out if infiltrator succeeded or if he got caught while infiltrating the border at 'The End' of the program.

Thanks for reading :)
