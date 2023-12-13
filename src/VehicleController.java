import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class VehicleController {

    private List<Vehicle> vehicles;
    private static double initX = 200;

    public VehicleController(VehicleView vehicleView, List<Vehicle> vehicleList) {
        this.vehicles = vehicleList;
        vehicleView.addGasListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gas = ((double) vehicleView.getGasAmount()) / 100;
                for (Vehicle vehicle : vehicles) {
                    vehicle.gas(gas);
                }
            }
        });

        vehicleView.addBrakeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gas = ((double) vehicleView.getGasAmount()) / 100;
                for (Vehicle vehicle : vehicles) {
                    vehicle.brake(gas);
                }
            }
        });

        vehicleView.addTurboOnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof Saab95) {
                        ((Saab95) vehicle).setTurboOn();
                    }
                }
            }
        });

        vehicleView.addTurboOffListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof Saab95) {
                        ((Saab95) vehicle).setTurboOff();
                    }
                }
            }
        });

        vehicleView.addLiftListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof Scania) {
                        ((Scania) vehicle).raisePlatform(70);
                    }
                }

            }
        });

        vehicleView.addLowerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof Scania) {
                        ((Scania) vehicle).lowerPlatform(70);
                    }
                }
            }
        });

        vehicleView.addCarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vehicles.size() < 10) {
                    initX += 100;
                    Random random = new Random();
                    int randomNumber = random.nextInt();
                    int result = randomNumber % 2;
                    if (result == 0)
                        vehicles.add(new Saab95(initX, 0));
                    else if (result == 1)
                        vehicles.add(new Volvo240(initX, 0));
                    else
                        vehicles.add(new Scania(initX, 0));
                }
            }
        });

        vehicleView.addRemoveCarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!vehicles.isEmpty()) {
                    initX -=100;
                    vehicles.removeLast();
                }
            }
        });

        vehicleView.addStartCarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.startEngine();
                }
            }
        });

        vehicleView.addStopCarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.stopEngine();
                }
            }
        });
    }


    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}


