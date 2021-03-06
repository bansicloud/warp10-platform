//
//   Copyright 2018-2020  SenX S.A.S.
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
//

package io.warp10.script.mapper;

import io.warp10.script.NamedWarpScriptFunction;
import io.warp10.script.WarpScriptException;
import io.warp10.script.WarpScriptStack;
import io.warp10.script.WarpScriptStackFunction;
import org.joda.time.DateTime;

/**
 * Mapper which returns the day of the week of the tick for which it
 * is computed.
 */
public class MapperDayOfWeek extends MapperDateTime {
  
  public static class Builder extends NamedWarpScriptFunction implements WarpScriptStackFunction {
    
    public Builder(String name) {
      super(name);
    }
    
    @Override
    public Object apply(WarpScriptStack stack) throws WarpScriptException {
      Object timezone = stack.pop();
      stack.push(new MapperDayOfWeek(getName(), timezone));
      return stack;
    }
  }

  public MapperDayOfWeek(String name, Object timezone) throws WarpScriptException {
    super(name, timezone);
  }

  @Override
  public Object getDateTimeInfo(DateTime dt, long tick) {
    return dt.getDayOfWeek();
  }
}
