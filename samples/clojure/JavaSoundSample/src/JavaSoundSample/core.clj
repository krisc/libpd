(ns JavaSoundSample.core
  (:import (java.io IOException)
           (org.puredata.core PdBase)))

(defn -main [& args]
  (def audioThread (new JavaSoundThread 44100 2 16))
  (def patch (PdBase/openPatch "src/pd/test.pd"))
  (.start audioThread)
  (Thread/sleep 5000)
  (.interrupt audioThread)
  (.join audioThread)
  (PdBase/closePatch patch))
