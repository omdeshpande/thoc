import {LitElement, html, PropertyDeclaration} from 'lit';
import {customElement, property} from 'lit/decorators.js';
import {unsafeHTML} from 'lit/directives/unsafe-html.js';

@customElement('user-edit-form')
export class UserEditForm extends LitElement {

    @property()
    content = '';

    constructor() {
        super();
        this.fetchData()
            .then((response) => response.text())
            .then((data) => {
				let json = JSON.parse(data);
                this.content = json.content.html;
            });
    }

    createRenderRoot() {
        return this; // turn off shadow dom to access external styles
    }

    async fetchData() {
        const response = fetch("/getUserEditForm", {
			headers: {
				'Content-Type': 'application/json'
			}
		});
        return response;
    }

    render() {
        return html`${unsafeHTML(this.content)}`;
    }
}
