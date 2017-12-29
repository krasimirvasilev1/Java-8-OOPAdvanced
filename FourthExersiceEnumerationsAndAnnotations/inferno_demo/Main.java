package FourthExersiceEnumerationsAndAnnotations.inferno_demo;

import FourthExersiceEnumerationsAndAnnotations.inferno_demo.io.ConsoleInputReader;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.io.ConsoleOutputWriter;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.io.InputReader;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.io.OutputWriter;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.api.WeaponInterface;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.engine.Engine;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.repositories.Repository;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.repositories.WeaponRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputReader reader = new ConsoleInputReader(bufferedReader);
        OutputWriter writer = new ConsoleOutputWriter();
        Repository<WeaponInterface> weaponRepository = new WeaponRepository<>();
        Runnable engine = new Engine(weaponRepository, reader, writer);

        engine.run();
    }
}
