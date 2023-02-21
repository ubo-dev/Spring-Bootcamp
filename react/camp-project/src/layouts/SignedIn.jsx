import React from 'react'
import { Dropdown, Menu, Image } from 'semantic-ui-react'

export default function SignedIn(props) {
  return (
    <div>
      <Menu.Item>
        <Image avatar spaced="right" src="data:image/jpeg;base64,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" />
        <Dropdown pointing="top left" text="umut">
          <Dropdown.Menu>
            <Dropdown.Item text="Information" icon="info" />
            <Dropdown.Item onClick={props.signOut} text="Sign Out" icon="sign-out" />
          </Dropdown.Menu>
        </Dropdown>
      </Menu.Item>
    </div>
  )
}
