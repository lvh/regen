# regen

Given a JSON object mapping regex names to regexes, return a JSON object of regex names to samples matching that given regex.


## Usage

    $ clj -m io.lvh.regen
       < dev-resources/regexes.json
       > dev-resources/samples.json

## License

Copyright © Laurens (lvh) Van Houtven

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
