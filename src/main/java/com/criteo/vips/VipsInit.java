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

public class VipsInit extends Vips {

    /**
     * getArgv0
     *
     *
     * @return a pointer to an internal copy of the argv0 string passed to
     * VIPS_INIT(). Do not free this value
     */
    public static native String getArgv0();

    /**
     * init
     * @param argv0 name of application
     *
     * This function starts up libvips, see VIPS_INIT(). 
     *
     * This function is for bindings which need to start up vips. C programs
     * should use the VIPS_INIT() macro, which does some extra checks. 
     *
     *
     * @return 0 on success, -1 otherwise
     */
    public static native int init(String argv0);

    public static native void checkInit();

    /**
     * threadShutdown 
     *
     * Free any thread-private data and flush any profiling information.
     *
     * This function needs to be called when a thread that has been using vips
     * exits. It is called for you by vips_shutdown() and for any threads created
     * by vips_g_thread_new(). 
     *
     * You will need to call it from threads created in
     * other ways or there will be memory leaks. If you do not call it, vips 
     * will generate a warning message.
     *
     * It may be called many times, and you can continue using vips after 
     * calling it. Calling it too often will reduce performance. 
     */
    public static native void threadShutdown();

    /**
     * shutdown
     *
     * Call this to drop caches and close plugins. Run with "--vips-leak" to do 
     * a leak check too. 
     *
     * You may call VIPS_INIT() many times and shutdown() many times, but you 
     * must not call VIPS_INIT() after shutdown(). In other words, you cannot
     * stop and restart vips. 
     */
    public static native void shutdown();

    /** 
     * guessPrefix
     * @param argv0 program name (typically argv[0])
     * @param env_name save prefix in this environment variable
     *
     * guessPrefix() tries to guess the install directory. You should pass 
     * in the value of argv[0] (the name your program was run as) as a clue to 
     * help it out, plus the name of the environment variable you let the user 
     * override your package install area with (eg. "VIPSHOME"). 
     *
     * On success, guessPrefix() returns the prefix it discovered, and as a 
     * side effect, sets the environment variable (if it's not set).
     *
     * Don't free the return string!
     * 
     *
     * @return (transfer none) the install prefix as a static string, do not free.
     */
    public static native String guessPrefix(String argv0, String envName);

    /** 
     * guessLibdir
     * @param argv0 program name (typically argv[0])
     * @param env_name save prefix in this environment variable
     *
     * guessLibdir() tries to guess the install directory (usually the 
     * configure libdir, or $prefix/lib). You should pass 
     * in the value of argv[0] (the name your program was run as) as a clue to 
     * help it out, plus the name of the environment variable you let the user 
     * override your package install area with (eg. "VIPSHOME"). 
     *
     * On success, guessLibdir() returns the libdir it discovered, and as a 
     * side effect, sets the prefix environment variable (if it's not set).
     *
     * Don't free the return string!
     * 
     *
     * @return (transfer none) the libdir as a static string, do not free.
     */
    public static native String guessLibdir(String argv0, String envName);

    /**
     * versionString
     *
     * Get the VIPS version as a static string, including a build date and time.
     * Do not free.
     *
     * @return (transfer none) a static version string
     */
    public static native String versionString();

    /**
     * version
     * @param flag which field of the version to get
     *
     * Get the major, minor or micro library version, with @param flag values 0, 1 and
     * 2.
     *
     * Get the ABI current, revision and age (as used by libtool) with @param flag 
     * values 3, 4, 5. 
     *
     * @return library version number
     */
    public static native int version(int flag);

    /**
     * leakSet
     * @param leak turn leak checking on or off
     *
     * Turn on or off vips leak checking. See also --vips-leak and
     * vips_add_option_entries(). 
     *
     * You should call this very early in your program. 
     */
    public static native void leakSet(boolean leak);
}