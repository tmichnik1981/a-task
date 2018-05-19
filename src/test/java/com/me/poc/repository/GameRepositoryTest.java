package com.me.poc.repository;

import com.me.poc.domain.game.player.Player;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameRepositoryTest {



    @Test
    public void shouldASave() throws Exception {

        //given

        GameRepository repository = new GameRepository();

      Player player = Player.builder()
          .withAttack(12)
          .withDefense(34)
          .withExperience(22)
          .withHealth(100)
          .withLevel(1)
          .withName("Sir Roderick")
          .build();

        //when

        boolean result =  repository.savePlayer(player, "ccc");

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldBList() throws Exception {
        //given
        GameRepository repository = new GameRepository();

        //when
       List<String>  files = repository.list();

        //then

       System.out.println(files);
    }

    @Test
    public void shouldCRead() throws Exception {
        //given
        Player expectedPlayer = Player.builder()
            .withAttack(12)
            .withDefense(34)
            .withExperience(22)
            .withHealth(100)
            .withLevel(1)
            .withName("Sir Roderick")
            .build();

        GameRepository repository = new GameRepository();

        //when

        Player player = repository.readPlayer("aaa");


        //then

        assertThat(player).isEqualTo(expectedPlayer);
    }

}