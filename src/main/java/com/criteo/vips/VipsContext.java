/*
  Copyright (c) 2019 Criteo

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

public class VipsContext extends Vips {
    /**
     * Set the number of worker threads that vips should use when running a VipsThreadPool
     *
     * @param concurrency 0 means "default", the number of threads available on the host machine
     */
    public static native void setConcurrency(int concurrency);

    /**
     * Get the number of worker threads that vips should use when running a VipsThreadPool
     *
     * @return thread number
     */
    public static native int getConcurrency();
}
