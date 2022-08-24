package com.mig.watch;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Profile({ "watch" })
@RequiredArgsConstructor
@Slf4j
public class WatchLauncher implements ApplicationListener<ApplicationReadyEvent>  {

	@Value("${spring.profiles.active}")
	private List<String> active;

	private final TestWatch testWatch;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		log.info("spring.profiles.active = {} ", active);

		try {
			testWatch.run();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
