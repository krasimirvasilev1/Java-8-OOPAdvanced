package panzer.manager;

import panzer.contracts.*;
import panzer.core.PanzerBattleOperator;
import panzer.io.ConsoleWriter;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerVechiclesImpl implements Manager {

    private Map<String, Vehicle> vechiclesAndParts;
    private OutputWriter outputWriter;
    private BattleOperator battleOperator;

    private List<String> defeatedVehicles;


    public ManagerVechiclesImpl() {
        this.vechiclesAndParts = new LinkedHashMap<>();
        this.outputWriter = new ConsoleWriter();
        this.battleOperator = new PanzerBattleOperator();
        this.defeatedVehicles = new ArrayList<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        switch (arguments.get(0)) {
            case "Revenger":
                this.vechiclesAndParts.put(arguments.get(1), new Revenger(arguments.get(1), Double.parseDouble(arguments.get(2)), new BigDecimal(arguments.get(3)), Integer.parseInt(arguments.get(4)), Integer.parseInt(arguments.get(5)), Integer.parseInt(arguments.get(6))));
                break;
            case "Vanguard":
                this.vechiclesAndParts.put(arguments.get(1), new Vanguard(arguments.get(1), Double.parseDouble(arguments.get(2)), new BigDecimal(arguments.get(3)), Integer.parseInt(arguments.get(4)), Integer.parseInt(arguments.get(5)), Integer.parseInt(arguments.get(6))));
                break;
        }

        return String.format("Created %s Vehicle - %s", arguments.get(0), arguments.get(1));
    }

    @Override
    public String addPart(List<String> arguments) {
        Part part = null;
        String partType = null;
        String partModel = arguments.get(2);
        String vechicleModel = this.vechiclesAndParts.get(arguments.get(0)).getModel();
        switch (arguments.get(1)) {
            case "Arsenal":
                part = new ArsenalPart(arguments.get(2), Double.parseDouble(arguments.get(3)), new BigDecimal(arguments.get(4)), Integer.parseInt(arguments.get(5)));
                this.vechiclesAndParts.get(arguments.get(0)).addArsenalPart(part);
                partType = "Arsenal";
                break;
            case "Shell":
                part = new ShellPart(arguments.get(2), Double.parseDouble(arguments.get(3)), new BigDecimal(arguments.get(4)), Integer.parseInt(arguments.get(5)));
                this.vechiclesAndParts.get(arguments.get(0)).addShellPart(part);
                partType = "Shell";
                break;
            case "Endurance":
                part = new EndurancePart(arguments.get(2), Double.parseDouble(arguments.get(3)), new BigDecimal(arguments.get(4)), Integer.parseInt(arguments.get(5)));
                this.vechiclesAndParts.get(arguments.get(0)).addEndurancePart(part);
                partType = "Endurance";
                break;
        }


        return String.format("Added %s - %s to Vehicle - %s", partType, partModel, vechicleModel);
    }

    @Override
    public String inspect(List<String> arguments) throws NoSuchFieldException, IllegalAccessException {
        Part part = null;
        Vehicle vehicle = null;
        boolean isVehicle = false;
        boolean breakFromEveryWhere = false;

        for (Map.Entry<String, Vehicle> stringVehicleEntry : this.vechiclesAndParts.entrySet()) {
            if (stringVehicleEntry.getKey().equals(arguments.get(0))){
                isVehicle = true;
                breakFromEveryWhere = true;
                vehicle = stringVehicleEntry.getValue();
                break;
            }
            for (Part part1 : stringVehicleEntry.getValue().getParts()) {
                if (part1.getModel().equals(arguments.get(0))){
                    isVehicle = false;
                    breakFromEveryWhere = true;
                    part = part1;
                    break;
                }
            }

            if (breakFromEveryWhere){
                break;
            }
        }

        if (isVehicle){
            return vehicle.toString();
        }
        else{
            return part.toString();
        }
    }

    @Override
    public String battle(List<String> arguments) {
        String result = this.battleOperator.battle(this.vechiclesAndParts.get(arguments.get(0)),this.vechiclesAndParts.get(arguments.get(1)));
        String output = String.format("%s versus %s -> %s Wins! Flawless Victory!",arguments.get(0),arguments.get(1),result);

        if (result.equals(arguments.get(0))) {
            this.defeatedVehicles.add(arguments.get(1));
        }
        else if (result.equals(arguments.get(1))){
            this.defeatedVehicles.add(arguments.get(0));
        }

        return output;
    }

    @Override
    public String terminate(List<String> arguments) throws NoSuchFieldException, IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        List<String> remainingVehicles = new ArrayList<>();
        List<Integer> partsOfTheremainingVehicles = new ArrayList<>();
        for (String defeatedVehicle : this.defeatedVehicles) {
            this.vechiclesAndParts.remove(defeatedVehicle);
        }

        for (Map.Entry<String, Vehicle> stringVehicleEntry : this.vechiclesAndParts.entrySet()) {
            stringVehicleEntry.getValue().getParts().forEach(x -> partsOfTheremainingVehicles.add(1));
            remainingVehicles.add(stringVehicleEntry.getKey());
        }

        if (remainingVehicles.isEmpty()){
            builder.append(String.format("Remaining Vehicles: None%n"));
        }
        else{
            builder.append(String.format("Remaining Vehicles: %s%n",String.join(", ",remainingVehicles)));
        }
        if (!this.defeatedVehicles.isEmpty()){
            builder.append(String.format("Defeated Vehicles: %s%n",String.join(", ",this.defeatedVehicles)));
        }
        else{
            builder.append(String.format("Defeated Vehicles: None%n"));
        }
        builder.append(String.format("Currently Used Parts: %d",partsOfTheremainingVehicles.size()));

        return builder.toString();
    }
}
