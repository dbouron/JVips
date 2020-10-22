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

public class VipsCache extends Vips {

    /**
     * print
     *
     * Print the whole operation cache to stdout. Handy for debugging.
     */
    public static native void print();

    /**
     * dropAll
     *
     * Drop the whole operation cache, handy for leak tracking. Also called
     * automatically on vips_shutdown().
     */
    public static native void dropAll();

    /**
     * setMax
     * @param max maximum number of operation to cache
     *
     * Set the maximum number of operations we keep in cache. 
     */
    public static native void setMax(int max);

    /**
     * setMaxMem
     * @param max_mem maximum amount of tracked memory we use 
     *
     * Set the maximum amount of tracked memory we allow before we start dropping
     * cached operations. See vips_tracked_get_mem().
     *
     * libvips only tracks memory it allocates, it can't track memory allocated by
     * external libraries. If you use an operation like vips_magickload(), most of
     * the memory it uses won't be included. 
     *
     */
    public static native void setMaxMem(long maxMem);

    /**
     * getMax
     *
     * Get the maximum number of operations we keep in cache. 
     *
     * @return the maximum number of operations we keep in cache
     */
    public static native int getMax();

    /**
     * getSize
     *
     * Get the current number of operations in cache. 
     *
     * @return get the current number of operations in cache.
     */
    public static native int getSize();

    /**
     * getMaxMem
     *
     * Get the maximum amount of tracked memory we allow before we start dropping
     * cached operations. See vips_tracked_get_mem().
     *
     *
     * @return the maximum amount of tracked memory we allow
     */
    public static native int getMaxMem();

    /**
     * getMaxFiles
     *
     * Get the maximum number of tracked files we allow before we start dropping
     * cached operations. See vips_tracked_get_files().
     *
     * libvips only tracks file descriptors it allocates, it can't track ones 
     * allocated by external libraries. If you use an operation like 
     * vips_magickload(), most of the descriptors it uses won't be included. 
     *
     *
     * @return the maximum number of tracked files we allow
     */
    public static native int getMaxFiles();

    /**
     * setMaxFiles
     * @param max_files max open files we allow
     *
     * Set the maximum number of tracked files we allow before we start dropping
     * cached operations. See vips_tracked_get_files().
     *
     */
    public static native void setMaxFiles(int maxFiles);

    /**
     * setDump
     * @param dump if %TRUE, dump the operation cache on exit
     *
     * Handy for debugging. Print the operation cache to stdout just before exit.
     *
     */
    public static native void setDump(boolean dump);

    /**
     * setTrace
     * @param trace if %TRUE, trace the operation cache 
     *
     * Handy for debugging. Print operation cache actions to stdout as we run.
     *
     * You can set the environment variable `VIPS_TRACE` to turn this option on, or
     * use the command-line flag `--vips-cache-trace`.
     *
     */
    public static native void setTrace(boolean trace);
}