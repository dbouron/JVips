/*
  Copyright (c) 2020 Criteo

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.criteo.vips.benchmark;
import com.criteo.vips.PixelPacket;
import com.criteo.vips.VipsContext;
import com.criteo.vips.VipsImage;
import com.criteo.vips.enums.VipsCompassDirection;
import com.criteo.vips.enums.VipsImageFormat;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class SimpleBenchmark {
    private static Dimension thumbnailTarget = new Dimension(512, 512);
    private static Rectangle cropTarget = new Rectangle(128, 128, 128, 128);
    private static Dimension padTarget = new Dimension(256, 256);
    private static PixelPacket pixelPacket = new PixelPacket(255.0, 255.0, 255.0);

    @Test
    public void TestBenchmark() throws Exception {

        Options opt = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode (Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(3)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(10)
                .threads(2)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Thread)
    public static class BenchmarkState
    {
        byte[] jpegContent;
        byte[] pngContent;

        @Setup(Level.Trial)
        public void initialize() throws IOException {
            ClassLoader classLoader = SimpleBenchmark.class.getClassLoader();
            String jpegPath = classLoader.getResource("in_vips.jpg").getFile();
            String pngPath = classLoader.getResource("in_vips.png").getFile();

            jpegContent = Files.readAllBytes(new File(jpegPath).toPath());
            pngContent = Files.readAllBytes(new File(pngPath).toPath());

            VipsContext.setMaxCache(0);
        }
    }

    @Benchmark
    public void ThumbnailCropPadJpeg(BenchmarkState state, Blackhole bh) {
        ThumbnailCropPad(state.jpegContent, VipsImageFormat.JPG);
    }

    @Benchmark
    public void ThumbnailCropPadPng(BenchmarkState state, Blackhole bh) {
        ThumbnailCropPad(state.pngContent, VipsImageFormat.PNG);
    }

    private void ThumbnailCropPad(byte[] content, VipsImageFormat format) {
        VipsImage img = new VipsImage(content, content.length);

        img.thumbnailImage(thumbnailTarget, false);
        img.crop(cropTarget);
        img.pad(padTarget, pixelPacket, VipsCompassDirection.Centre);
        byte[] out = img.writeToArray(format, 80, false);
        img.release();
    }
}
