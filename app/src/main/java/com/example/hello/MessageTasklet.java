package com.example.hello;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

// Tasklet 実装クラス
public class MessageTasklet implements Tasklet {

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
    System.out.println("hello"); // メッセージを出力
    return RepeatStatus.FINISHED; // 処理が終了したことを示す値を返す
  }
}