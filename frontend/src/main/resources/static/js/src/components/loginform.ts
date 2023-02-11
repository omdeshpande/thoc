import {LitElement, html, PropertyDeclaration} from 'lit';
import {customElement, property} from 'lit/decorators.js';
import {unsafeHTML} from 'lit/directives/unsafe-html.js';

@customElement('login-form')
export class LoginForm extends LitElement {

    @property()
    content = '';

    constructor() {
        super();
        this.fetchData()
            .then((response) => response.text())
            .then((data) => {
                this.content = data;
            });
    }

    createRenderRoot() {
        return this; // turn off shadow dom to access external styles
    }

    async fetchData() {
        const response = fetch("http://localhost:8080/login");
        return response;
    }

    render() {
        return html`${unsafeHTML(this.content)}`;
    }
}