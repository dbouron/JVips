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

package com.criteo.vips;

public class VipsThreadpool extends Vips {

    /**
     * set
     * @param concurrency number of threads to run
     *
     * Sets the number of worker threads that vips should use when running a
     * #VipsThreadPool. 
     *
     * The special value 0 means "default". In this case, the number of threads is
     * set by the environment variable VIPS_CONCURRENCY, or if that is not set, the
     * number of threads availble on the host machine. 
     *
     */
    public static native void set(int concurrency);

    /**
     * get
     *
     * @return the number of worker threads that vips should use when running a
     * #VipsThreadPool. 
     *
     * vips gets this values from these sources in turn
     *
     * If vips_concurrency_set() has been called, this value is used. The special
     * value 0 means "default". You can also use the command-line argument
     * "--vips-concurrency" to set this value.
     *
     * If vips_concurrency_set() has not been called and no command-line argument
     * was used, vips uses the value of the environment variable VIPS_CONCURRENCY,
     *
     * If VIPS_CONCURRENCY has not been set, vips find the number of hardware
     * threads that the host machine can run in parallel and uses that value. 
     *
     * The final value is clipped to the range 1 - 1024.
     *
     *
     * @return number of worker threads to use.
     */
    public static native int get();
}