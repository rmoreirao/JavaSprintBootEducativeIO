package com.example.jdbcexample.tennisplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerRepository repo;

	@Autowired
	PlayerSpringDataRepository dataRepo;

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    @Override
    public void run(String... args) {
		runRepo();
		runDataRepo();
	}

	private void runRepo() {
		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));

		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));

		logger.info("\n\n>> Player with id 2: {}\n", repo.getPlayerById(2));

		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player("Thiem", "Austria",
						new Date(System.currentTimeMillis()), 17)));
		//update player
		logger.info("\n\n>> Updating Player with Id 3: {}\n", repo.updatePlayer(
				new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));
		//get player
		logger.info("\n\n>> Player with id 3: {}\n", repo.getPlayerById(3));

		repo.deleteById(2);

		logger.info("\n\n>> All Players Data: {}", repo.getAllPlayers());
	}

	private void runDataRepo(){
		logger.info("\n\n>>Inserting Player: {}\n", dataRepo.save(new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
		logger.info("\n\n>>Inserting Player: {}\n", dataRepo.save(new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));
		logger.info("\n\n>>Inserting Player: {}\n", dataRepo.save(new Player("Thiem", "Austria", new Date(System.currentTimeMillis()), 17)));
		logger.info("\n\n>>Updating Player with Id 3: {}\n", dataRepo.save(new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));
		logger.info("\n\n>>Player with Id 2: {}\n", dataRepo.findById(2));
		repo.deleteById(2);
		logger.info("\n\n>>All Players Data: {}\n", dataRepo.findAll());
	}
}
